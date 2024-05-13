package com.imeghebe.jwt.backend.services;

import com.imeghebe.jwt.backend.dtos.MovieStatusDTO;
import com.imeghebe.jwt.backend.dtos.UserProfileOutputDTO;
import com.imeghebe.jwt.backend.entites.UserMovie;

import java.util.List;

public interface UserMovieService {
    List<UserMovie> getMoviesForUser(Long userId);

    void removeUserMovie(Long userId, String movieId);

    void updateMovieStatus(Long id, MovieStatusDTO movieStatusDTO);

    void save(UserMovie userMovie);
}
