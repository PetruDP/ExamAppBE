package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);

}
