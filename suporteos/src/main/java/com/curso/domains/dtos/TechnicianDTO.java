package com.curso.domains.dtos;



import java.time.LocalDate; import java.util.HashSet; import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


import com.curso.domains.Technician;
import com.curso.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class TechnicianDTO {

    protected UUID id;

    @NotNull(message =  "O campo nome não pode ser nulo")
    @NotBlank(message =  "O campo nome não pode ser vazio")
    protected String firstName; 
    
    @NotNull(message =  "O campo sobrenome não pode ser nulo")
    @NotBlank(message =  "O campo sobrenome não pode ser vazio")
    protected String lastName;

    @NotNull(message =  "O campo CPF não pode ser nulo")
    @NotBlank(message =  "O campo CPF não pode ser vazio")
    protected String cpf;

    @NotNull(message =  "O campo e-mail não pode ser nulo")
    @NotBlank(message =  "O campo e-mail não pode ser vazio")
    protected String email;

    @NotNull(message =  "O campo senha não pode ser nulo")
    @NotBlank(message =  "O campo senha não pode ser vazio")
    protected String password;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();
    
    protected Set<Integer> personType = new HashSet<>();
    
    public TechnicianDTO() {
    }

    public TechnicianDTO(Technician obj) { 
        
    this.id = obj.getId();
    this.firstName = obj.getFirstName();
    this.lastName = obj.getLastName();
    this.cpf = obj.getCpf();
    this.email = obj.getEmail();
    this.password = obj.getPassword();
    this.createdAt = obj.getCreatedAt();
    this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
    }
   
    public UUID getId() {
     return id;
    }

    public void setId(UUID id) {
     this.id = id;
    }

    public String getFirstName() {
     return firstName;
    }

    public void setFirstName(String firstName) {
     this.firstName = firstName;
    }
    
    public String getLastName() {
     return lastName;
    }

    public void setLastName(String lastName) { 
        this.lastName = lastName;
    }

    public String getCpf() {
      return cpf;
    }
     
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
    return password;
     }

  public void setPassword(String password) { 
    this.password = password;
   }

  public LocalDate getCreatedAt() {
   return createdAt;
   }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
 } 

   public Set<PersonType> getPersonType() {
    return personType.stream().map(x -> PersonType.toEnum(x)).collect(Collectors.toSet());
    }

   public void addPersonType (PersonType personType) {
     this.personType.add(personType.getId());

    }
}