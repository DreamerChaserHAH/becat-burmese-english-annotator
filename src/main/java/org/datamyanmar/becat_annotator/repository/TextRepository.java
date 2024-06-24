package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.Text;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends CrudRepository<Text, Integer> {
    @Query("SELECT t FROM Text t LEFT JOIN AnnotationAudit aa ON t.id = aa.id.textid WHERE aa.id.userid < ?1 OR aa.id.userid > ?1 OR aa.id.userid IS NULL ORDER BY t.annotatedVotes DESC LIMIT 1")
    Text getTextToBeAnnotated(@Param("userID") Integer userID);
}
