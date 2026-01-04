package com.web.microservice.userservice.service.impl;

import com.web.microservice.userservice.entity.User;
import com.web.microservice.userservice.exception.DuplicateResourceFoundException;
import com.web.microservice.userservice.exception.InvalidDataException;
import com.web.microservice.userservice.exception.ResourceNotFoundException;
import com.web.microservice.userservice.repository.UserRepository;
import com.web.microservice.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //TODO: DEPENDENCY-INJECTION USING CONSTRUCTOR
    private final UserRepository userRepository;


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
        return userRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("user","id",id));
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
