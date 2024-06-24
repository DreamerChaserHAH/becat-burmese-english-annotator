package org.datamyanmar.becat_annotator.repository;

import org.datamyanmar.becat_annotator.model.User;
import org.datamyanmar.becat_annotator.model.UserId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, UserId> {
    @Query("SELECT u FROM User u WHERE u.id.loginid = ?1")
    Optional<User> findByLoginID(@Param("loginID") String loginID);
    @Query("SELECT u FROM User u WHERE u.id.userid = ?1")
    Optional<User> findByID(@Param("id") Integer id);
}
