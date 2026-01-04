package com.web.microservice.hotelservice.controllers;

import com.web.microservice.hotelservice.entities.Hotel;
import com.web.microservice.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelControllers {

    private final HotelService hotelService;

    //TODO: CREATE HOTEl
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel hotelData = hotelService.save(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelData);
    }

    //TODO: UPDATE HOTEL
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel){
        Hotel updatedData = hotelService.update(id, hotel);

        return ResponseEntity.ok(updatedData);
    }

    //TODO: GET ALL HOTEL INFORMATION
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotelInfo(){
        List<Hotel> hotelInfos = hotelService.findAll();

        return ResponseEntity.ok(hotelInfos);
    }


    //TODO: GET HOTEL INFO
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelInfoById(@PathVariable Long id){
        Hotel hotel = hotelService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }


    //TODO : REMOVE THE HOTEL INFO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotelInfo(@PathVariable Long id){

        hotelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


















}
