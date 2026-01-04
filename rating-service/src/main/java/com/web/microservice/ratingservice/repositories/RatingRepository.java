package com.web.microservice.ratingservice.repositories;

import com.web.microservice.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    //custom finder methods
    List<Rating> findByUserId(Long userId);
    List<Rating> findByHotelId(String hotelId);

}
