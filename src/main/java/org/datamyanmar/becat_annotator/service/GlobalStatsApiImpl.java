package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.GlobalStatsApiDelegate;
import org.datamyanmar.becat_annotator.model.GlobalStatsGet200Response;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
class GlobalStatsApiImpl implements GlobalStatsApiDelegate {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<GlobalStatsGet200Response> globalStatsGet() {
        return ResponseEntity.ok(new GlobalStatsGet200Response().totalAnnotatedData(10).totalAnnotations(10));
    }
}