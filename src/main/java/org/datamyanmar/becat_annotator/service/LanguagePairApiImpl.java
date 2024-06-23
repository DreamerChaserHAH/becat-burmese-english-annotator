package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.LanguagePairApiDelegate;
import org.datamyanmar.becat_annotator.model.LanguagePairAnnotatePostRequest;
import org.datamyanmar.becat_annotator.model.LanguagePairGetGet200Response;
import org.datamyanmar.becat_annotator.model.UserLoginPost401Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LanguagePairApiImpl implements LanguagePairApiDelegate {
    @Override
    public ResponseEntity<LanguagePairGetGet200Response> languagePairGetGet() {
        return LanguagePairApiDelegate.super.languagePairGetGet();
    }

    @Override
    public ResponseEntity<UserLoginPost401Response> languagePairAnnotatePost(LanguagePairAnnotatePostRequest languagePairAnnotatePostRequest) {
        return LanguagePairApiDelegate.super.languagePairAnnotatePost(languagePairAnnotatePostRequest);
    }
}
