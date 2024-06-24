package org.datamyanmar.becat_annotator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AnnotationAuditId implements java.io.Serializable {
    private static final long serialVersionUID = 5026538298914995272L;
    @javax.validation.constraints.NotNull
    @Column(name = "textid", nullable = false)
    private Integer textid;

    @javax.validation.constraints.NotNull
    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnnotationAuditId entity = (AnnotationAuditId) o;
        return Objects.equals(this.textid, entity.textid) &&
                Objects.equals(this.userid, entity.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textid, userid);
    }

}