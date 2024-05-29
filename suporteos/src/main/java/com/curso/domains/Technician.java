package com.curso.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.curso.domains.dtos.TechnicianDTO;
import com.curso.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "techinician")
public class Technician extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "techinician")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician(UUID id, String firstName, String lastName, String cpf, String email, String password){
       super(id, firstName, lastName, cpf, email, password);
       addPersonType(PersonType.TECHNICIAN);
    }

 public Technician (TechnicianDTO obj) { 
   this.id = obj.getId();
   this.firstName = obj.getFirstName();
   this.lastName = obj.getLastName(); this.cpf = obj.getCpf();
   this.email = obj.getEmail();
   this.password = obj.getPassword();
   this.createdAt = obj.getCreatedAt();
   this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet()); 
   addPersonType (PersonType.USERS);
   addPersonType (PersonType.TECHNICIAN);

 }
    
    public Technician() {
        super();
        addPersonType(PersonType.TECHNICIAN);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    
}
