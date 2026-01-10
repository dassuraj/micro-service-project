package com.web.microservice.hotelservice.services;

import com.web.microservice.hotelservice.entities.Servent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServentService {

    Servent save(Servent servent);

    List<Servent> findAll();

    Servent findById(Long id);


}
