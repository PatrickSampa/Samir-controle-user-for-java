package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/informationsForCalcule")
//informa qual a rota ele deve redirecionar para o controller
public class CreationInformationForCalcule {
 
    @GetMapping()
    public ResponseEntity<String> getInformationForCalcule(){
        return ResponseEntity.ok("Informaçes para o cálculo");
    }
}
