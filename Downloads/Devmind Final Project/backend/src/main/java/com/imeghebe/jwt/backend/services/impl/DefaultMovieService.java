package com.imeghebe.jwt.backend.services.impl;

import com.imeghebe.jwt.backend.entites.Movie;
import com.imeghebe.jwt.backend.repositories.*;
import com.imeghebe.jwt.backend.services.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {

    private final MovieRepository movieRepository;
    private final PictureRepository pictureRepository;
    private final StarRepository starRepository;
    private final GenreRepository genreRepository;
    private final DirectorRepository directorRepository;
    private final WriterRepository writerRepository;


    @Override
    @Transactional
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional
    public void saveAll(List<Movie> movies) {
        movies.forEach(movie -> {
            if (!movie.getImages().isEmpty()) {
                pictureRepository.saveAll(movie.getImages());
            }
            if (!movie.getGenre().isEmpty()) {
                genreRepository.saveAll(movie.getGenre());
            }
            if (!movie.getWriters().isEmpty()) {
                writerRepository.saveAll(movie.getWriters());
            }
            if (!movie.getStars().isEmpty()) {
                starRepository.saveAll(movie.getStars());
            }
            if (!movie.getDirector().isEmpty()) {
                directorRepository.saveAll(movie.getDirector());
            }
            movieRepository.save(movie);
        });
    }

    @Override
    @Transactional
    public Movie findById(String movieId) {
        return movieRepository.findById(movieId).orElseThrow();
    }
}
