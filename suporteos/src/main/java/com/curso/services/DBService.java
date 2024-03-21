package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domains.ServiceOrder;
import com.curso.domains.Technician;
import com.curso.domains.Users;
import com.curso.domains.enums.OrderPriority;
import com.curso.domains.enums.OrderStatus;
import com.curso.repositories.ServiceOrderRepository;
import com.curso.repositories.TechnicianRepository;
import com.curso.repositories.UsersRepository;

@Service
public class DBService {

    @Autowired
    private TechnicianRepository techRepo;

    @Autowired
    private UsersRepository userRepo;
    
    @Autowired
    private ServiceOrderRepository osRepo; 

    public void initDB()
    {
        Technician tec1 = new 
            Technician(null,"Jefferson","Passerini",
            "89308024000","jefferson.passerini@gmail.com","123");
        
        Users user01 = new Users(null, "Joao", "Alberto", 
        "02569095099", "joao.alberto@gmail.com", "123");

        Users user02 = new Users(null, "Jose", "Felipe", 
        "02569095044", "jose.felipe@gmail.com", "123");

        ServiceOrder os01 = new ServiceOrder(null, "test", "OS test", 
        OrderPriority.HIGH, OrderStatus.OPEN, tec1, user02);

        techRepo.save(tec1);
        userRepo.save(user01);
        userRepo.save(user02);
        osRepo.save(os01);
        
    }
}
