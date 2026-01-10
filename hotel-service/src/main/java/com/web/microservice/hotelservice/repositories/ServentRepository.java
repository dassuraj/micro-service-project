package com.web.microservice.hotelservice.repositories;

import com.web.microservice.hotelservice.entities.Servent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServentRepository extends JpaRepository<Servent,Long> {

    Optional<Servent> findByName(String name);
    Optional<Servent> findByEmail(String email);

    boolean existsByName(String name);
    boolean existsByEmail(String email);


}
