package com.web.microservice.hotelservice.services.impl;

import com.web.microservice.hotelservice.entities.Hotel;
import com.web.microservice.hotelservice.exceptions.InvalidDataException;
import com.web.microservice.hotelservice.exceptions.ResourceNotFoundException;
import com.web.microservice.hotelservice.repositories.HotelRepository;
import com.web.microservice.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {

        if (hotel == null){
            throw new InvalidDataException("hotel data is invalid!!!");
        }

        if (hotel.getName()==null || hotel.getLocation() == null){
            throw new InvalidDataException("hotel name/location is null !!!!");
        }

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Long id, Hotel hotel) {

        boolean isExists = hotelRepository.existsById(id);

        if (!isExists){
            throw new ResourceNotFoundException("hotel", "id", id);
        }
        if (hotel == null){
            throw new InvalidDataException("invalid data is present !!!");
        }

        Hotel existingHotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("hotel" , "id" ,id));

        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());

        return hotelRepository.save(existingHotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {

        return hotelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("hotel","id",id));
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
