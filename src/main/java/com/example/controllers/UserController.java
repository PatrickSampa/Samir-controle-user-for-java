package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.createUserDTO;
import com.example.entities.User;
import com.example.service.UserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserUseCase userUseCase;


    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody @Valid createUserDTO user) throws Exception {
        System.out.println(user);
        User createUser = userUseCase.registerUser(user);
        return ResponseEntity.ok(createUser);
    }

}
