package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.LogoutApiDelegate;
import org.datamyanmar.becat_annotator.model.LoginPost401Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogoutApiImpl implements LogoutApiDelegate {
    @Override
    public ResponseEntity<LoginPost401Response> logoutPost() {
        return LogoutApiDelegate.super.logoutPost();
    }
}
