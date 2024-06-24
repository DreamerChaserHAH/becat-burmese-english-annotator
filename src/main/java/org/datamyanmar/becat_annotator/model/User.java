package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @EmbeddedId
    private UserId id;

    @Column(name = "display_name", length = Integer.MAX_VALUE)
    private String displayName;

    @Column(name = "hash", length = Integer.MAX_VALUE)
    private String hash;

    @Column(name = "salt", length = Integer.MAX_VALUE)
    private String salt;

    @Column(name = "total_annotated")
    private Integer totalAnnotated;

}