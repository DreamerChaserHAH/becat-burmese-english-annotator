package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AnnotationAuditId implements java.io.Serializable {
    private static final long serialVersionUID = -5471505093231515425L;
    @NotNull
    @Column(name = "\"UserID\"", nullable = false)
    private Integer userID;

    @NotNull
    @Column(name = "\"TextID\"", nullable = false)
    private Integer textID;

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