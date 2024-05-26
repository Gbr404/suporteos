package com.curso.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.curso.services.TechnicianService; 
import com.curso.domains.dtos.TechnicianDTO;

@RestController
@RequestMapping(value = "/technician") 
public class TechnicianResource {

    @Autowired
private TechnicianService techService;

@GetMapping //exemplo http://localhost:8080/technician 
public ResponseEntity<List<TechnicianDTO>> findAll(){
return ResponseEntity.ok().body(techService.findAll());
}

}
