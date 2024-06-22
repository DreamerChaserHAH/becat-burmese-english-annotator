package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class AnnotationAuditId implements java.io.Serializable {
    private static final long serialVersionUID = -5471505093231515425L;
    @Column(name = "\"UserID\"", nullable = false)
    private Integer userID;

    @Column(name = "\"TextID\"", nullable = false)
    private Integer textID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTextID() {
        return textID;
    }

    public void setTextID(Integer textID) {
        this.textID = textID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnnotationAuditId entity = (AnnotationAuditId) o;
        return Objects.equals(this.textID, entity.textID) &&
                Objects.equals(this.userID, entity.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textID, userID);
    }

}