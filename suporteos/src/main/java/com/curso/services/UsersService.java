package com.curso.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.curso.repositories.UsersRepository;
import com.curso.domains.dtos.UsersDTO;


@Service
public class UsersService {

@Autowired
  private UsersRepository usersRepo;
public List<UsersDTO> findAll(){
//retorna uma lista de UsersDTO
return usersRepo.findAll().stream().map(obj -> new UsersDTO(obj)).collect (Collectors.toList());

}

}
