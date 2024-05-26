package com.curso.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.curso.repositories.TechnicianRepository;
import com.curso.domains.dtos.TechnicianDTO;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository techRepo;
    
    public List<TechnicianDTO> findAll(){
   
    //retorna uma lista de TechnicianDTO
    return techRepo.findAll().stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
       }
}
