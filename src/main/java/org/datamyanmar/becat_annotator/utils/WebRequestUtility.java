package org.datamyanmar.becat_annotator.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.datamyanmar.becat_annotator.model.User;
import org.datamyanmar.becat_annotator.repository.UserRepository;

import io.jsonwebtoken.security.SignatureException;
import java.util.Optional;

public class WebRequestUtility
{
    public static String getToken(HttpServletRequest request){
        String token = "";
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return token;
    }

    public static Optional<User> validateUserFromToken(UserRepository userRepository, HttpServletResponse response, String token){
        Jws<Claims> claims;
        try {
            claims = JwtTokenUtility.getJwsClaims(token);
        }catch(SignatureException | java.security.SignatureException e){
            WebResponseUtility.addCookie(response, "token", "");
            return Optional.empty();
        }
        String userValue = JwtTokenUtility.getUser(claims);
        if(userValue != null && !userValue.isEmpty() && !JwtTokenUtility.isExpired(claims)){
            return userRepository.findByID(Integer.parseInt(userValue));
        }
        WebResponseUtility.addCookie(response, "token", "");
        return Optional.empty();
    }
}
