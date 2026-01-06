package com.web.microservice.userservice.service.impl;

import com.web.microservice.userservice.entity.User;
import com.web.microservice.userservice.exception.DuplicateResourceFoundException;
import com.web.microservice.userservice.exception.InvalidDataException;
import com.web.microservice.userservice.exception.ResourceNotFoundException;
import com.web.microservice.userservice.model.Hotel;
import com.web.microservice.userservice.model.Rating;
import com.web.microservice.userservice.repository.UserRepository;
import com.web.microservice.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //TODO: DEPENDENCY-INJECTION USING CONSTRUCTOR
    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserService.class);


    //TODO: CREATE USER
    @Override
    public User create(User user) {
        if (user == null ){
            throw new InvalidDataException("user can't be null ");
        }

        user.setEmail(user.getEmail().toLowerCase());
        if (userRepository.existsByEmail(user.getEmail())){
            throw new DuplicateResourceFoundException("Email already exists");
        }

        return userRepository.save(user);
    }

    //TODO: UPDATE USER
    @Override
    public User update(User user) {
        if (user == null || user.getId() <= 0) {
            throw new InvalidDataException("user can't be null or id can't be null or negative");
        }

        User existingUser = userRepository.findById(user.getId()).
                orElseThrow(() -> new ResourceNotFoundException("User ", "id", user.getId()));

        if (!existingUser.getEmail().equals(user.getEmail())){
            if (userRepository.existsByEmail(user.getEmail())){
                throw new DuplicateResourceFoundException("Email already exists");
            }
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());

        return userRepository.save(existingUser);
    }

    //TODO: FIND USER BY ID
    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("user","id",id));

        //Fetch rating of the above user from rating-service
        //http://localhost:8083/rating/users/1

       Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getId(),Rating[].class);

       List<Rating>  ratings = Arrays.stream(ratingsOfUsers).toList();

      List<Rating> ratingList = ratings.stream().map(rating->{
          //api call to hotel service to get hotel
          //http://localhost:8082/hotels/1

          ResponseEntity<Hotel> hotelDetails= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
          Hotel hotel = hotelDetails.getBody();
          logger.info("response status code : {}",hotelDetails.getStatusCode());

          //set the hotel to rating
          rating.setHotel(hotel);

          //return the rating
          return rating;
        }).collect(Collectors.toList()) ;
        user.setRatings(ratingList);

        return user;

    }

    //TODO: FIND ALL USER
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //TODO : REMOVE USER BY ID
    @Override
    public void delete(Long id) {
       boolean exist = userRepository.existsById(id);

       if (!exist){
           throw new ResourceNotFoundException("user","id",id);
       }
       userRepository.deleteById(id);
    }
}
