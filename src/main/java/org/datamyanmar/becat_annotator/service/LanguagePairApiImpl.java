package org.datamyanmar.becat_annotator.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.datamyanmar.becat_annotator.api.LanguagePairApiDelegate;
import org.datamyanmar.becat_annotator.model.*;
import org.datamyanmar.becat_annotator.repository.AnnotationAuditRepository;
import org.datamyanmar.becat_annotator.repository.TextRepository;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.datamyanmar.becat_annotator.utils.JwtTokenUtility;
import org.datamyanmar.becat_annotator.utils.WebRequestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class LanguagePairApiImpl implements LanguagePairApiDelegate {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AnnotationAuditRepository annotationAuditRepository;
    @Autowired
    TextRepository textRepository;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @Override
    ///<summary>
    ///Get one language pair with the following set of conditions:
    ///- The language pair is not annotated by the user
    ///- The language pair has less than 100 annotations
    ///</summary>
    public ResponseEntity<GetLanguagePair200Response> getLanguagePair() {
        String token = WebRequestUtility.getToken(request);
        if(token == null || token.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<User> user = WebRequestUtility.validateUserFromToken(userRepository, response, token);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Integer userId = user.get().getId();
        Text text = textRepository.getTextToBeAnnotated(userId);
        if(text == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GetLanguagePair200Response response = new GetLanguagePair200Response();
        response.setLanguagePairIdJwt(JwtTokenUtility.createJwtToken(text.getId()));
        response.setBurmese(text.getBurmese());
        response.setEnglish(text.getEnglish());
        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<String> annotateLanguagePair(AnnotateLanguagePairRequest annotateLanguagePairRequest) {
        String token = WebRequestUtility.getToken(request);
        if(token == null || token.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<User> user = WebRequestUtility.validateUserFromToken(userRepository, response, token);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        System.out.println(textRepository.count());
        Integer userId = user.get().getId();

        Optional<Jws<Claims>> claimsOptional = WebRequestUtility.validateClaims(annotateLanguagePairRequest.getLanguagePairIdJwt());
        if(claimsOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AnnotationAudit auditRecord = getAnnotationAudit(annotateLanguagePairRequest, claimsOptional, userId);
        annotationAuditRepository.save(auditRecord);

        return new ResponseEntity<>("Annotation Created/Updated Successfully", HttpStatus.OK);
    }

    private AnnotationAudit getAnnotationAudit(AnnotateLanguagePairRequest annotateLanguagePairRequest, Optional<Jws<Claims>> claimsOptional, Integer userId) {
        Integer textId = Integer.parseInt(claimsOptional.get().getPayload().getSubject());
        System.out.println("Text ID: " + textId);

        String annotation = annotateLanguagePairRequest.getAnnotation().toString();
        String feedback = annotateLanguagePairRequest.getFeedback();

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();

        Optional<Text> textOptional = textRepository.findById(textId);
        if(textOptional.isEmpty()){
            throw new RuntimeException("Text not found");
        }
        Text text = textOptional.get();

        AnnotationAudit auditRecord = new AnnotationAudit();
        AnnotationAuditId auditRecordId = new AnnotationAuditId();
        auditRecord.setUserid(user);
        auditRecord.setTextid(text);
        auditRecord.setId(auditRecordId);
        auditRecord.setAnnotation(annotation);
        auditRecord.setFeedback(feedback);
        auditRecord.setTimestamp(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        return auditRecord;
    }
}
