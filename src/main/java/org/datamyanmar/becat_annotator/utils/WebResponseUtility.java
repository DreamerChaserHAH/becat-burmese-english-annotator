package org.datamyanmar.becat_annotator.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class WebResponseUtility {
    public static void addCookie(HttpServletResponse response, String token, String value){
        Cookie cookie = new Cookie(token, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 7); //expiration date set 1 week from today
        response.addCookie(cookie);
    }
}
