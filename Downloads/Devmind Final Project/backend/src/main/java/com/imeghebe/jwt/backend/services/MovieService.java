package com.imeghebe.jwt.backend.services;


import com.imeghebe.jwt.backend.entites.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    void saveAll(List<Movie> movies);

    Movie findById(String movieId);
}
