package com.curso.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation. RequestMapping;
import org.springframework.web.bind.annotation. RestController;

import com.curso.services.UsersService; 
import com.curso.domains.dtos.UsersDTO;


@RestController
@RequestMapping(value = "/users")

public class UsersResource {

    @Autowired
    private UsersService usersService;
    @GetMapping //exemplo http://localhost:8080/users 
    public ResponseEntity<List<UsersDTO>> findAll(){
    return ResponseEntity.ok().body (usersService.findAll());
    }
    
}
