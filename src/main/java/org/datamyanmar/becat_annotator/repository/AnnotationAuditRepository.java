package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.AnnotationAudit;
import org.datamyanmar.becat_annotator.model.AnnotationAuditId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationAuditRepository extends CrudRepository<AnnotationAudit, AnnotationAuditId> {
    List<AnnotationAudit> findByIdUserid(Integer userID, Pageable pageable);
    Integer countByIdUserid(Integer userID);
    @Query("SELECT COUNT(a) FROM AnnotationAudit a WHERE a.id.userid = ?1 AND a.timestamp = CURRENT_DATE()")
    Integer countByIdUseridAnnotatedToday(Integer userID);
}
