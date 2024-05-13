package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
