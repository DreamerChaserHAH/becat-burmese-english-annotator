package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"annotation audit\"")
public class AnnotationAudit {
    @EmbeddedId
    private AnnotationAuditId id;

    @MapsId("textid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "textid", nullable = false)
    private Text textid;

    @MapsId("userid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "feedback", length = Integer.MAX_VALUE)
    private String feedback;

    @javax.validation.constraints.NotNull
    @Column(name = "annotation", nullable = false, length = Integer.MAX_VALUE)
    private String annotation;

    @javax.validation.constraints.NotNull
    @Column(name = "\"timestamp\"", nullable = false)
    private LocalDate timestamp;

}