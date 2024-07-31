package com.example.securityconfig;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.entities.User;


@Service
public class TokenConfig {
    
    @Value("${jwt.secret}")
    private String secretKey = "secret";

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                           .withIssuer("samir-controle")
                           .withSubject(user.getUsername())
                           .withExpiresAt(getExpirationDate())
                           .sign(algorithm);
                           return token;



        }catch(JWTCreationException e){
            throw new RuntimeException("Error creating token", e);
        }

    }


    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
            .withIssuer("samir-controle")
            .build()
            .verify(token)
            .getSubject();
        }catch(JWTVerificationException e){
            throw new RuntimeException("Token invalid or expired", e);
        }
    }


    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
