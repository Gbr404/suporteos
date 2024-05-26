package com.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.services.DBService;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @PostConstruct
    public void initDB(){
        if(value.equals("create")){
            this.dbService.initDB();
        }
    }

}
