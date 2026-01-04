package com.web.microservice.ratingservice.services;

import com.web.microservice.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    //TODO: CREATE RATING
    Rating create(Rating rating);

    //TODO: GET ALL RATING
    List<Rating> getAllRatings();


    //TODO: GET ALL BY USERID
    List<Rating> findRatingByUserId(Long userId );


    //TODO: GET ALL BY HOTEL
    public List<Rating> findRatingByHotelId(String  hotelId);


}
