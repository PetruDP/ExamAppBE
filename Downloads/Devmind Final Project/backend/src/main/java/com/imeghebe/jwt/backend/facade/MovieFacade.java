package com.imeghebe.jwt.backend.facade;

import com.imeghebe.jwt.backend.dtos.ImdbMovieDTO;
import com.imeghebe.jwt.backend.dtos.MovieDTO;

import java.util.List;

public interface MovieFacade {
    List<MovieDTO> getTopMovies();

    void updateTop100(List<ImdbMovieDTO> imdbTop100);

    MovieDTO getMovieById(String movieId);
}
