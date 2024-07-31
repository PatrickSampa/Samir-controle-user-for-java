package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
   UserDetails findByUsername(String username);
   UserDetails findByCpf(String cpf);
}
