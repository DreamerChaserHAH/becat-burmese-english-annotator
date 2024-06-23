package org.datamyanmar.becat_annotator.service;

import org.datamyanmar.becat_annotator.api.GlobalStatsApiDelegate;
import org.datamyanmar.becat_annotator.model.GlobalStatsGet200Response;
import org.datamyanmar.becat_annotator.repository.AnnotationAuditRepository;
import org.datamyanmar.becat_annotator.repository.TextRepository;
import org.datamyanmar.becat_annotator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
class GlobalStatsApiImpl implements GlobalStatsApiDelegate {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TextRepository textRepository;
    @Autowired
    private AnnotationAuditRepository annotationAuditRepository;

    @Override
    public ResponseEntity<GlobalStatsGet200Response> globalStatsGet() {
        int annotatedDataCount = (int) annotationAuditRepository.count();
        int totalTextCount = (int) textRepository.count();
        int unansweredTextCount = totalTextCount - annotatedDataCount;
        return ResponseEntity.ok(
                new GlobalStatsGet200Response()
                        .totalUsers((int) userRepository.count())
                        .totalAnnotatedData(annotatedDataCount)
                        .totalUnannotatedData(unansweredTextCount)
                        .totalText(totalTextCount)
        );
    }
}