package com.web.microservice.hotelservice.services;

import com.web.microservice.hotelservice.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {


    //TODO: CREATE HOTEL
    public Hotel save(Hotel hotel);

    //TODO : UPDATE HOTEL
    public Hotel update(Long id, Hotel hotel);

    //TODO: GET ALL HOTEL INFORMATION
    public List<Hotel> findAll();

    //TODO: GET SPECIFIC HOTEL
    public Hotel findById(Long id);

    //TODO: REMOVE THE HOTEL
    public void delete(Long id);
}
