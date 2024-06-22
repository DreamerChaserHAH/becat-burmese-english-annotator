package org.datamyanmar.becat_annotator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.datamyanmar.becat_annotator.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
