package com.curso.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.domains.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

}
