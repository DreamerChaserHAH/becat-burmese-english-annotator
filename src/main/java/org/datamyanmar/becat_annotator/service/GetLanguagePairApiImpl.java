package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.GetLanguagePairApiDelegate;
import org.datamyanmar.becat_annotator.model.GetLanguagePairGet200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetLanguagePairApiImpl implements GetLanguagePairApiDelegate{
    @Override
    public ResponseEntity<GetLanguagePairGet200Response> getLanguagePairGet() {
        return GetLanguagePairApiDelegate.super.getLanguagePairGet();
    }
}
