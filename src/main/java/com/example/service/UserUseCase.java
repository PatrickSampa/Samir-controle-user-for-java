package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.createUserDTO;
import com.example.entities.User;
import com.example.repositories.UserRepository;


@Service
public class UserUseCase {

    
    @Autowired
    private UserRepository userRepository;

    public  User registerUser(createUserDTO user) throws Exception{
        if((this.userRepository.findByCpf(user.cpf())) != null)  throw new Exception("User already exists");

        String encrypyedPassword = new BCryptPasswordEncoder().encode(user.password());
        User newUser = new User(user.username(), user.name(), encrypyedPassword, user.rg(), user.cpf(), user.role());
        System.out.println("chegou aqui");
        System.out.println(newUser);
        this.userRepository.save(newUser);

        return newUser;
    }
}
