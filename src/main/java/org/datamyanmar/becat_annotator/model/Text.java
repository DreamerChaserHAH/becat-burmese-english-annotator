package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"Text\"")
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Text_id_gen")
    @SequenceGenerator(name = "Text_id_gen", sequenceName = "Text_TextID_seq", allocationSize = 1)
    @Column(name = "\"TextID\"", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "\"AnnotatedVotes\"", nullable = false)
    private Integer annotatedVotes;
    @ColumnDefault("0")
    @Column(name = "\"NotOk\"", nullable = false)
    private Integer notOk;

    @ColumnDefault("0")
    @Column(name = "\"Ok\"", nullable = false)
    private Integer ok;
    @ColumnDefault("0")
    @Column(name = "\"Maybe\"", nullable = false)
    private Integer maybe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnotatedVotes() {
        return annotatedVotes;
    }

    public void setAnnotatedVotes(Integer annotatedVotes) {
        this.annotatedVotes = annotatedVotes;
    }

    public Integer getOk() {
        return ok;
    }

    public void setOk(Integer ok) {
        this.ok = ok;
    }

    public Integer getNotOk() {
        return notOk;
    }

    public void setNotOk(Integer notOk) {
        this.notOk = notOk;
    }

    public Integer getMaybe() {
        return maybe;
    }

    public void setMaybe(Integer maybe) {
        this.maybe = maybe;
    }

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