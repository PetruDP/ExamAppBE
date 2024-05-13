package com.imeghebe.jwt.backend.services.impl;

import com.imeghebe.jwt.backend.dtos.MovieStatusDTO;
import com.imeghebe.jwt.backend.entites.UserMovie;
import com.imeghebe.jwt.backend.repositories.UserMovieRepository;
import com.imeghebe.jwt.backend.services.UserMovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserMovieService implements UserMovieService {

    private final UserMovieRepository userMovieRepository;

    @Override
    @Transactional
    public List<UserMovie> getMoviesForUser(Long userId) {
        return userMovieRepository.findAllByUserId(userId).isPresent() ?
                userMovieRepository.findAllByUserId(userId).get() : Collections.emptyList();
    }

    @Override
    @Transactional
    public void removeUserMovie(Long userId, String movieId) {
        UserMovie userMovie = userMovieRepository.findByUserIdAndMovieId(userId, movieId);
        userMovieRepository.delete(userMovie);
    }

    @Override
    @Transactional
    public void updateMovieStatus(Long userId, MovieStatusDTO movieStatusDTO) {
        UserMovie userMovie =  userMovieRepository.findByUserIdAndMovieId(userId, movieStatusDTO.getMovieId());
        userMovie.setMovieStatus(movieStatusDTO.getMovieStatus());
        userMovieRepository.save(userMovie);
    }

    @Override
    @Transactional
    public void save(UserMovie userMovie) {
        userMovieRepository.save(userMovie);
    }
}
