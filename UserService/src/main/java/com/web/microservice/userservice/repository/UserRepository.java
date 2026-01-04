package com.web.microservice.userservice.repository;

import com.web.microservice.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    //TODO: GET USER BY USERNAME AND EMAIL
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

    //TODO :VALIDATION CHECKS
    boolean existsByName(String name);
    boolean existsByEmail(String email);


}
