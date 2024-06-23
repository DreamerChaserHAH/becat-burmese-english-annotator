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
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "\"UserID\"", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "\"LoginID\"", nullable = false, length = Integer.MAX_VALUE)
    private String loginID;

    @NotNull
    @Column(name = "\"Salt\"", nullable = false, length = Integer.MAX_VALUE)
    private String salt;

    @NotNull
    @Column(name = "\"Hash\"", nullable = false, length = Integer.MAX_VALUE)
    private String hash;

    @NotNull
    @Column(name = "\"DisplayName\"", nullable = false, length = Integer.MAX_VALUE)
    private String displayName;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "\"TotalAnnotated\"", nullable = false)
    private Integer totalAnnotated;

}