package com.web.microservice.userservice.service;

import com.web.microservice.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //TODO: CREATE USER
    public User create(User user);

    //TODO: UPDATE USER
    public User update(User user);

    //TODO: FIND USER BY ID
    public User findById(Long id);

    //TODO : FIND ALL USER
    public List<User> findAll();

    //TODO: DELETE USER BY ID
    public void delete(Long id);


}
