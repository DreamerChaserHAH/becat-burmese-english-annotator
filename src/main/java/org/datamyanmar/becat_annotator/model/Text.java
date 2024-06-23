package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "\"Text\"")
public class Text {
    @Id
    @Column(name = "\"TextID\"", nullable = false)
    private Integer id;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "\"AnnotatedVotes\"", nullable = false)
    private Integer annotatedVotes;
    @NotNull
    @ColumnDefault("0")
    @Column(name = "\"NotOk\"", nullable = false)
    private Integer notOk;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "\"Ok\"", nullable = false)
    private Integer ok;
    @NotNull
    @ColumnDefault("0")
    @Column(name = "\"Maybe\"", nullable = false)
    private Integer maybe;

/*
 TODO [Reverse Engineering] create field to map the '\"English\"' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "\"English\"", columnDefinition = "bytea[] not null")
    private Object english;
*/
/*
 TODO [Reverse Engineering] create field to map the '\"Burmese\"' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "\"Burmese\"", columnDefinition = "bytea[] not null")
    private Object burmese;
*/
}