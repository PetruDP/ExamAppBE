package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
}
