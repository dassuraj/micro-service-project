package com.web.microservice.hotelservice.services.impl;


import com.web.microservice.hotelservice.entities.Servent;
import com.web.microservice.hotelservice.exceptions.InvalidDataException;
import com.web.microservice.hotelservice.repositories.ServentRepository;
import com.web.microservice.hotelservice.services.ServentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServentServiceImpl implements ServentService {

    private final ServentRepository serventRepository;



    @Override
    public Servent save(Servent servent) {

        if(servent == null){
            throw new InvalidDataException("invalid servent data!");
        }
        if (servent.getAge()>=17 ){
            throw new InvalidDataException("servant must be greater than or equal to 18!");
        }

        if (servent.getEmail() == null){
            throw new InvalidDataException("email is required!");
        }

        if (servent.getName() == null){
            throw new InvalidDataException("Name is Required!!");
        }





        return serventRepository.save(servent);
    }

    @Override
    public List<Servent> findAll() {
        return List.of();
    }

    @Override
    public Servent findById(Long id) {
        return null;
    }
}
