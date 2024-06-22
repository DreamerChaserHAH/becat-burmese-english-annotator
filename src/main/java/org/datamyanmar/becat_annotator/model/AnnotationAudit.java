package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Annotation Audit\"")
public class AnnotationAudit {
    @EmbeddedId
    private AnnotationAuditId id;

    @Column(name = "\"Annotation\"", nullable = false)
    private Short annotation;

    @Column(name = "\"Feedback\"", length = Integer.MAX_VALUE)
    private String feedback;

    public AnnotationAuditId getId() {
        return id;
    }

    public void setId(AnnotationAuditId id) {
        this.id = id;
    }

    public Short getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Short annotation) {
        this.annotation = annotation;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}