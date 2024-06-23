package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.loginID = ?1")
    Optional<User> findByLoginID(@Param("loginID") String loginID);
}
