package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"annotation audit\"")
public class AnnotationAudit {
    @EmbeddedId
    private AnnotationAuditId id;

    @Column(name = "feedback", length = Integer.MAX_VALUE)
    private String feedback;

    @javax.validation.constraints.NotNull
    @ColumnDefault("now()")
    @Column(name = "\"timestamp\"", nullable = false)
    private LocalDate timestamp;

    @javax.validation.constraints.NotNull
    @Column(name = "annotation", nullable = false, length = Integer.MAX_VALUE)
    private String annotation;

}