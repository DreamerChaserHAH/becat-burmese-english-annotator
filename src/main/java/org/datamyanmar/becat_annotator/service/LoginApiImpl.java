package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.LoginApiDelegate;
import org.datamyanmar.becat_annotator.model.LoginPost200Response;
import org.datamyanmar.becat_annotator.model.LoginPostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginApiImpl implements LoginApiDelegate {
    @Override
    public ResponseEntity<LoginPost200Response> loginPost(LoginPostRequest loginPostRequest) {
        return LoginApiDelegate.super.loginPost(loginPostRequest);
    }
}
