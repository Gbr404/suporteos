package com.curso.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.domains.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    

}
