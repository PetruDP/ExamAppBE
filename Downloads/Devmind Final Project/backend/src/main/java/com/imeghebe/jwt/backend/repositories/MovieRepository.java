package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
