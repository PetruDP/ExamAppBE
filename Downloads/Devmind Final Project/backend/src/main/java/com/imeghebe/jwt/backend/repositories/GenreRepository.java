package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
