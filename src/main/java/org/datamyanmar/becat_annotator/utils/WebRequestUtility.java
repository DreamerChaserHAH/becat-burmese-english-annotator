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

    public static Optional<Jws<Claims>> validateClaims(String token){
        try {
            return Optional.of(JwtTokenUtility.getJwsClaims(token));
        }catch(SignatureException | java.security.SignatureException e){
            return Optional.empty();
        }
    }

    public static Optional<User> validateUserFromToken(UserRepository userRepository, HttpServletResponse response, String token){
        Optional<Jws<Claims>> claimsOptional = validateClaims(token);
        if(claimsOptional.isEmpty()){
            WebResponseUtility.addCookie(response, "token", "");
            return Optional.empty();
        }

        Jws<Claims> claims = claimsOptional.get();
        String userValue = JwtTokenUtility.getUser(claims);
        if(userValue != null && !userValue.isEmpty() && !JwtTokenUtility.isExpired(claims)){
            return userRepository.findById(Integer.parseInt(userValue));
        }

        WebResponseUtility.addCookie(response, "token", "");
        return Optional.empty();
    }
}
