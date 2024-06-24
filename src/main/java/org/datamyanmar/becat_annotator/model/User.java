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
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "userid", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @Column(name = "loginid", nullable = false, length = Integer.MAX_VALUE)
    private String loginid;

    @Column(name = "display_name", length = Integer.MAX_VALUE)
    private String displayName;

    @javax.validation.constraints.NotNull
    @Column(name = "hash", nullable = false, length = Integer.MAX_VALUE)
    private String hash;

    @javax.validation.constraints.NotNull
    @Column(name = "salt", nullable = false, length = Integer.MAX_VALUE)
    private String salt;

    @javax.validation.constraints.NotNull
    @ColumnDefault("0")
    @Column(name = "total_annotated", nullable = false)
    private Integer totalAnnotated;

}