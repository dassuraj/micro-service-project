package com.web.microservice.userservice;

import com.web.microservice.userservice.external.service.RatingService;
import com.web.microservice.userservice.model.Rating;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private  RatingService ratingService;


//    @Test
//    void createRating(){
//        Rating rating = Rating.builder().rating(10).userId(5L).hotelId("").feedback("Best hotel").build();
//        ratingService.createRating(rating);
//
//        System.out.println("new rating created ");
//    }


}
