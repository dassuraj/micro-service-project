package com.web.microservice.ratingservice.controllers;

import com.web.microservice.ratingservice.entities.Rating;
import com.web.microservice.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingControllers {

    private final RatingService ratingService;

    //TODO: CREATE RATING
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //TODO: GET ALL RATING
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return  ResponseEntity.ok(ratingService.getAllRatings());
    }


    //TODO: GET ALL RATING BY USERID
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getAllRatingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(ratingService.findRatingByUserId(userId));
    }

    //TODO: GET ALL RATING BY HOTEL-ID
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<?> getAllRatingByHotelId(@PathVariable String hotelId){

        return ResponseEntity.ok(ratingService.findRatingByHotelId(hotelId));
    }


}
