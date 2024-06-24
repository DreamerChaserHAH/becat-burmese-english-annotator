package org.datamyanmar.becat_annotator.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.datamyanmar.becat_annotator.api.UserApiDelegate;
import org.datamyanmar.becat_annotator.model.*;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.datamyanmar.becat_annotator.repository.AnnotationAuditRepository;
import org.datamyanmar.becat_annotator.utils.JwtTokenUtility;
import org.datamyanmar.becat_annotator.utils.WebRequestUtility;
import org.datamyanmar.becat_annotator.utils.WebResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApiImpl implements UserApiDelegate {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnnotationAuditRepository annotationAuditRepository;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    private void setLoginToken(User user){
        String jwtToken = JwtTokenUtility.createJwtToken(user.getId().getUserid());
        WebResponseUtility.addCookie(response, "token", jwtToken);
    }

    @Override
    public ResponseEntity<LoginUser200Response> loginUser(LoginUserRequest userLoginPostRequest) {

        //check if there's an existing token
        //if yes, try login with that token
        //  check if the token is valid and the user exists
        //      if yes, login and update the expiration date of the token
        //      if no, return unauthorized
        //if no, skip this step
        String token = WebRequestUtility.getToken(request);
        if(token != null && !token.isEmpty()) {
            Optional<User> user = WebRequestUtility.validateUserFromToken(userRepository, response, token);
            if (user.isPresent()) {
                setLoginToken(user.get());
                return new ResponseEntity<>(new LoginUser200Response().message("Login Successful"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }

        String loginId = userLoginPostRequest.getLoginid();
        String password = userLoginPostRequest.getPassword();
        Optional<User> userOptional = userRepository.findByLoginID(loginId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getHash().equals(BCrypt.hashpw(password, user.getSalt()))){
                //Create JWT Token to be stored on the client device for authorization
                setLoginToken(user);
                return new ResponseEntity<>(new LoginUser200Response().message("Login Successful"), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    @Override
    public ResponseEntity<LoginUser200Response> logoutUser() {
        WebResponseUtility.addCookie(response, "token", "");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ///<summary>
    ///get the list of activities that the user have done
    ///</summary>
    @Override
    public ResponseEntity<GetUserHistory200Response> getUserHistory() {

        Integer userId = 0;
        String token = WebRequestUtility.getToken(request);
        if(token != null && !token.isEmpty()) {
            Optional<User> user = WebRequestUtility.validateUserFromToken(userRepository, response, token);
            if (user.isPresent()) {
                userId = user.get().getId().getUserid();
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }

        GetUserHistory200Response response = new GetUserHistory200Response();
        PageRequest pageRequest = PageRequest.of(0, 5);

        response.totalAnnotations(annotationAuditRepository.countByIdUserid(userId));
        response.annotatedToday(annotationAuditRepository.countByIdUseridAnnotatedToday(userId));

        for(AnnotationAudit record: annotationAuditRepository.findByIdUserid(userId, pageRequest)){
            response.addHistoryItem(new GetUserHistory200ResponseHistoryInner()
                    .languagePairId(record.getId().getTextid())
                    .annotation(AnnotationType.fromValue(record.getAnnotation()))
                    .feedback(record.getFeedback())
                    .timestamp(record.getTimestamp().toString())
            );
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
