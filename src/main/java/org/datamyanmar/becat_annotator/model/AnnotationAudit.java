package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "\"Annotation Audit\"")
public class AnnotationAudit {
    @EmbeddedId
    private AnnotationAuditId id;

    @NotNull
    @Column(name = "\"Annotation\"", nullable = false)
    private Short annotation;

    @Column(name = "\"Feedback\"", length = Integer.MAX_VALUE)
    private String feedback;

}