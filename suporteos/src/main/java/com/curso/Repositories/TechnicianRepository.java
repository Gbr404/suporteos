package com.curso.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.domains.Technician;
import java.util.Optional;


@Repository
public interface TechnicianRepository extends JpaRepository<Technician, UUID> {
    Optional<Technician> findByCpf(String cpf);
    Optional<Technician> findByEmail(String email);
}
