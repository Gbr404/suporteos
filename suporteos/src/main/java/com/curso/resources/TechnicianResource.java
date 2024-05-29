package com.curso.resources;


import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.services.TechnicianService;

import jakarta.validation.Valid;

import com.curso.domains.Technician;
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

@GetMapping(value = "/{id}")
public ResponseEntity<TechnicianDTO> findById(@PathVariable UUID id) {
    Technician obj = this.techService.findbyId(id);
    return ResponseEntity.ok().body( new TechnicianDTO(obj));
}

@GetMapping(value = "/cpf/{cpf}")
public ResponseEntity<TechnicianDTO> findByCpf(@PathVariable String cpf){
    Technician obj = this.techService.findbyCpf(cpf);
    return ResponseEntity.ok().body(new TechnicianDTO(obj));
}

@GetMapping(value = "/email/{email}")
public ResponseEntity<TechnicianDTO> findByEmail(@PathVariable String email){
    Technician obj = this.techService.findbyEmail(email);
    return ResponseEntity.ok().body(new TechnicianDTO(obj));
}

 @PostMapping
 public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO objDto){
  Technician newObj = techService.create(objDto);
  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand (newObj.getId()).toUri(); 
  return ResponseEntity.created(uri).build();

 }

 @PutMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable UUID id, @Valid @RequestBody TechnicianDTO objDto){
        Technician Obj = techService.update(id, objDto);
        return ResponseEntity.ok().body(new TechnicianDTO(Obj));
    }

    @DeleteMapping
    public ResponseEntity<TechnicianDTO> delete(@PathVariable UUID id){
        techService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
