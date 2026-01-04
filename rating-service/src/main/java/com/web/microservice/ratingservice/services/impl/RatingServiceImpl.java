package com.web.microservice.ratingservice.services.impl;

import com.web.microservice.ratingservice.entities.Rating;
import com.web.microservice.ratingservice.exceptions.InvalidDataException;
import com.web.microservice.ratingservice.repositories.RatingRepository;
import com.web.microservice.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    //TODO: CREATE RATING
    @Override
    public Rating create(Rating rating) {

        if (rating == null){
            throw new InvalidDataException("rating data is invalid !!!");
        }
        if (rating.getUserId() == null || rating.getHotelId() == null){
            throw new InvalidDataException("invalid rating / hotelId !!!");
        }
        
        return ratingRepository.save(rating);
    }

    //TODO :  GET ALL RATING
    @Override
    public List<Rating> getAllRatings() {

        return ratingRepository.findAll();

    }

    //TODO : GET RATING BY USERID
    @Override
    public List<Rating> findRatingByUserId(Long userId) {

        return ratingRepository.findByUserId(userId);

    }


    //TODO : GET RATING BY HOTEL
    @Override
    public List<Rating> findRatingByHotelId(String hotelId) {

        return ratingRepository.findByHotelId(hotelId);

    }
}
