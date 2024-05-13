package com.imeghebe.jwt.backend.facade.impl;

import com.imeghebe.jwt.backend.dtos.ImdbMovieDTO;
import com.imeghebe.jwt.backend.dtos.MovieDTO;
import com.imeghebe.jwt.backend.facade.MovieFacade;
import com.imeghebe.jwt.backend.mappers.ImdbMovieMapper;
import com.imeghebe.jwt.backend.mappers.MovieMapper;
import com.imeghebe.jwt.backend.services.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultMovieFacade implements MovieFacade {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final ImdbMovieMapper imdbMovieMapper;

    @Override
    @Transactional
    public List<MovieDTO> getTopMovies() {
        return movieMapper.toDto(movieService.findAll());
    }

    @Override
    @Transactional
    public void updateTop100(List<ImdbMovieDTO> imdbTop100) {
        movieService.saveAll(movieMapper.toEntity(imdbMovieMapper.toMovieDTOFromImdbMovieDTO(imdbTop100)));
    }

    @Override
    @Transactional
    public MovieDTO getMovieById(String movieId) {
        return movieMapper.toDto(movieService.findById(movieId));
    }
}
