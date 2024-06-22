package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_id_gen")
    @SequenceGenerator(name = "User_id_gen", sequenceName = "User_UserID_seq", allocationSize = 1)
    @Column(name = "\"UserID\"", nullable = false)
    private Integer id;

    @Column(name = "\"LoginID\"", nullable = false, length = Integer.MAX_VALUE)
    private String loginID;

    @Column(name = "\"Salt\"", nullable = false, length = Integer.MAX_VALUE)
    private String salt;

    @Column(name = "\"Hash\"", nullable = false, length = Integer.MAX_VALUE)
    private String hash;

    @Column(name = "\"DisplayName\"", nullable = false, length = Integer.MAX_VALUE)
    private String displayName;

    @ColumnDefault("0")
    @Column(name = "\"TotalAnnotated\"", nullable = false)
    private Integer totalAnnotated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getTotalAnnotated() {
        return totalAnnotated;
    }

    public void setTotalAnnotated(Integer totalAnnotated) {
        this.totalAnnotated = totalAnnotated;
    }

}