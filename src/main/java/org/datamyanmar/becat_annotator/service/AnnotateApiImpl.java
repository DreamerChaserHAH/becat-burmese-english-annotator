package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.AnnotateApiDelegate;
import org.datamyanmar.becat_annotator.model.AnnotatePostRequest;
import org.datamyanmar.becat_annotator.model.LoginPost401Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnnotateApiImpl implements AnnotateApiDelegate {
    @Override
    public ResponseEntity<LoginPost401Response> annotatePost(AnnotatePostRequest annotatePostRequest) {
        return AnnotateApiDelegate.super.annotatePost(annotatePostRequest);
    }
}
