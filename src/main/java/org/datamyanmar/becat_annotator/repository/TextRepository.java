package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends CrudRepository<Text, Integer> {

}
