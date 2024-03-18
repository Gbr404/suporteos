package com.curso.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.curso.domains.enums.PersonType;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@EntityScan
@Table(name = "techinician")
public class Technician extends Person {

    @OneToMany(mappedBy = "techinician")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician(UUID id, String firstName, String lastName, String cpf, String email, String password){
       super(id, firstName, lastName, cpf, email, password);
       addPersonType(PersonType.TECHNICIAN);
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
