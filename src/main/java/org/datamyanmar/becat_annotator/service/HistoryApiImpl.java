package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.HistoryApiDelegate;
import org.datamyanmar.becat_annotator.model.HistoryGet200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryApiImpl implements HistoryApiDelegate {
    @Override
    public ResponseEntity<HistoryGet200Response> historyGet() {
        return HistoryApiDelegate.super.historyGet();
    }
}
