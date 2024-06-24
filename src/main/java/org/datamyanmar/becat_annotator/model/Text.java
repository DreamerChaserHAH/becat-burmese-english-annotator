package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "text")
public class Text {
    @Id
    @Column(name = "textid", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @ColumnDefault("0")
    @Column(name = "annotated_votes", nullable = false)
    private Integer annotatedVotes;

    @javax.validation.constraints.NotNull
    @ColumnDefault("0")
    @Column(name = "maybe", nullable = false)
    private Integer maybe;

    @javax.validation.constraints.NotNull
    @ColumnDefault("0")
    @Column(name = "not_ok", nullable = false)
    private Integer notOk;

    @javax.validation.constraints.NotNull
    @ColumnDefault("0")
    @Column(name = "ok", nullable = false)
    private Integer ok;

    @Column(name = "burmese", length = Integer.MAX_VALUE)
    private String burmese;

    @Column(name = "english", length = Integer.MAX_VALUE)
    private String english;

}