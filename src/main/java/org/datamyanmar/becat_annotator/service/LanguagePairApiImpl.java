package org.datamyanmar.becat_annotator.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.datamyanmar.becat_annotator.api.LanguagePairApiDelegate;
import org.datamyanmar.becat_annotator.model.*;
import org.datamyanmar.becat_annotator.repository.AnnotationAuditRepository;
import org.datamyanmar.becat_annotator.repository.TextRepository;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.datamyanmar.becat_annotator.utils.WebRequestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
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

        System.out.println(textRepository.count());
        Integer userId = user.get().getId().getUserid();
        Text text = textRepository.getTextToBeAnnotated(userId);
        if(text == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GetLanguagePair200Response response = new GetLanguagePair200Response();
        response.setId(text.getId());
        response.setBurmese(text.getBurmese());
        response.setEnglish(text.getEnglish());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<LoginUser200Response> annotateLanguagePair(AnnotateLanguagePairRequest annotateLanguagePairRequest) {
        return LanguagePairApiDelegate.super.annotateLanguagePair(annotateLanguagePairRequest);
    }
}
