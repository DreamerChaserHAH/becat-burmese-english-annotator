package org.datamyanmar.becat_annotator.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.datamyanmar.becat_annotator.api.UserApiDelegate;
import org.datamyanmar.becat_annotator.model.*;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;

import java.security.Key;

import java.util.Optional;

@Service
public class UserApiImpl implements UserApiDelegate {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Override
    public ResponseEntity<UserLoginPost200Response> userLoginPost(UserLoginPostRequest userLoginPostRequest) {
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            if(cookies.length > 0){
                for(Cookie cookie: cookies){
                    if(cookie.getName().equals("token")){
                        //try login
                        //if token is valid, return 200
                        //if token is invalid, return 401 and asks to login again
                    }
                }
            }
        }

        String loginId = userLoginPostRequest.getUserId();
        String password = userLoginPostRequest.getPassword();
        Optional<User> userOptional = userRepository.findByLoginID(loginId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getHash().equals(BCrypt.hashpw(password, user.getSalt()))){
                //Create JWT Token to be stored on the client device for authorization

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.HOUR, 1);

                String jwtToken = Jwts.builder()
                        .subject(user.getId().toString())
                        .issuedAt(new Date())
                        .expiration(calendar.getTime())
                        //.setExpiration(calendar.getTime())
                        //.signWith(SignatureAlgorithm.HS256, "secretkey")
                        .compact();

                //ServletRequestAttributes attr = (ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes();

                    Cookie cookie = new Cookie("token", jwtToken);
                    cookie.setHttpOnly(true);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println(response.containsHeader("Set-Cookie"));
                return new ResponseEntity<>(new UserLoginPost200Response().token(jwtToken), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseEntity<UserLoginPost401Response> userLogoutPost() {
        return UserApiDelegate.super.userLogoutPost();
    }

    @Override
    public ResponseEntity<UserHistoryGet200Response> userHistoryGet() {
        return UserApiDelegate.super.userHistoryGet();
    }
}
