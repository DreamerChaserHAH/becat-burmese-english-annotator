package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.AnnotationAudit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationAuditRepository extends CrudRepository<AnnotationAudit, Integer> {

}
