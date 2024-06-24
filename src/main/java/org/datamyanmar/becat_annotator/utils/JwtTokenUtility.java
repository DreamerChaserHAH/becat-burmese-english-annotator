package org.datamyanmar.becat_annotator.utils;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.Date;

public class JwtTokenUtility
{
    private static final SecretKey key = Jwts.SIG.HS256.key().build();
    public static String createJwtToken(Integer userID){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 24);

        return Jwts.builder()
                .subject(userID.toString())
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(key)
                .compact();
    }

    public static String getUser(Jws<Claims> claims){
        return claims.getPayload().getSubject();
    }

    public static boolean isExpired(Jws<Claims> claims){
        return claims.getPayload().getExpiration().before(new Date());
    }

    public static Jws<Claims> getJwsClaims(String token) throws SignatureException {
        Jws<Claims> claims =  Jwts.parser().setSigningKey(key).build().parseSignedClaims(token);
        return claims;
    }

}
