package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.ImdbMovieDTO;
import com.imeghebe.jwt.backend.dtos.MovieDTO;
import com.imeghebe.jwt.backend.dtos.PictureDTO;
import com.imeghebe.jwt.backend.entites.Director;
import com.imeghebe.jwt.backend.entites.Genre;
import com.imeghebe.jwt.backend.entites.Star;
import com.imeghebe.jwt.backend.entites.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface ImdbMovieMapper {

    @Mapping(target = "images", expression = "java(mapPictures(imdbMovieDTO.getImages()))")
    @Mapping(target = "genre", expression = "java(mapGenres(imdbMovieDTO.getGenre()))")
    @Mapping(target = "director", expression = "java(mapDirectors(imdbMovieDTO.getDirector()))")
    @Mapping(target = "stars", expression = "java(mapStars(imdbMovieDTO.getStars()))")
    @Mapping(target = "writers", expression = "java(mapWriters(imdbMovieDTO.getWriters()))")
    MovieDTO toMovieDTOFromImdbMovieDTO(ImdbMovieDTO imdbMovieDTO);

    @Mapping(target = "images", expression = "java(mapPictures(imdbMovieDTO.getImages()))")
    @Mapping(target = "genre", expression = "java(mapGenres(imdbMovieDTO.getGenre()))")
    @Mapping(target = "director", expression = "java(mapDirectors(imdbMovieDTO.getDirector()))")
    @Mapping(target = "stars", expression = "java(mapStars(imdbMovieDTO.getStars()))")
    @Mapping(target = "writers", expression = "java(mapWriters(imdbMovieDTO.getWriters()))")
    List<MovieDTO> toMovieDTOFromImdbMovieDTO(List<ImdbMovieDTO> imdbMovieDTO);

    default List<PictureDTO> mapPictures(List<List<String>> images) {
        return !Objects.isNull(images) ? images.stream()
                .map(imageList -> PictureDTO.builder()
                            .image(imageList.get(1))
                            .width(imageList.get(0))
                            .build())
                .collect(Collectors.toList()) : Collections.emptyList();
    }
    default List<Writer> mapWriters(List<String> writers) {
        return !Objects.isNull(writers) ? writers.stream()
                .map(writerName -> {
                    Writer writer = new Writer();
                    writer.setName(writerName);
                    return writer;
                })
                .collect(Collectors.toList()) : Collections.emptyList();
    }
    default List<Genre> mapGenres(List<String> genres) {
        return !Objects.isNull(genres) ? genres.stream()
                .map(genreName -> {
                    Genre genre = new Genre();
                    genre.setName(genreName);
                    return genre;
                })
                .collect(Collectors.toList()) : Collections.emptyList();
    }
    default List<Director> mapDirectors(List<String> directors) {
        return !Objects.isNull(directors) ? directors.stream()
                .map(directorName -> {
                    Director director = new Director();
                    director.setName(directorName);
                    return director;
                })
                .collect(Collectors.toList()) : Collections.emptyList();
    }
    default List<Star> mapStars(List<String> stars) {
        return !Objects.isNull(stars) ? stars.stream()
                .map(starName -> {
                    Star star = new Star();
                    star.setName(starName);
                    return star;
                })
                .collect(Collectors.toList()) : Collections.emptyList();
    }

}
