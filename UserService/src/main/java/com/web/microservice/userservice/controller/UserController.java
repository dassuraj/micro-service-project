package com.web.microservice.userservice.controller;

import com.web.microservice.userservice.entity.User;
import com.web.microservice.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    //TODO: CREATE USER
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //TODO : GET SINGLE USER
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){

        User user = userService.findById(id);
        return ResponseEntity.ok(user);

    }

    //TODO: GET ALL USER
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    //TODO:  UPDATE USER
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){

        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }


    //TODO: DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){

        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
