package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.ImdbMovieDTO;
import com.imeghebe.jwt.backend.dtos.MovieDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T14:55:16+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ImdbMovieMapperImpl implements ImdbMovieMapper {

    @Override
    public MovieDTO toMovieDTOFromImdbMovieDTO(ImdbMovieDTO imdbMovieDTO) {
        if ( imdbMovieDTO == null ) {
            return null;
        }

        MovieDTO.MovieDTOBuilder movieDTO = MovieDTO.builder();

        movieDTO.id( imdbMovieDTO.getId() );
        movieDTO.title( imdbMovieDTO.getTitle() );
        movieDTO.description( imdbMovieDTO.getDescription() );
        movieDTO.link( imdbMovieDTO.getLink() );
        movieDTO.imdbid( imdbMovieDTO.getImdbid() );
        movieDTO.rank( imdbMovieDTO.getRank() );
        movieDTO.rating( imdbMovieDTO.getRating() );
        movieDTO.year( imdbMovieDTO.getYear() );

        movieDTO.images( mapPictures(imdbMovieDTO.getImages()) );
        movieDTO.genre( mapGenres(imdbMovieDTO.getGenre()) );
        movieDTO.director( mapDirectors(imdbMovieDTO.getDirector()) );
        movieDTO.stars( mapStars(imdbMovieDTO.getStars()) );
        movieDTO.writers( mapWriters(imdbMovieDTO.getWriters()) );

        return movieDTO.build();
    }

    @Override
    public List<MovieDTO> toMovieDTOFromImdbMovieDTO(List<ImdbMovieDTO> imdbMovieDTO) {
        if ( imdbMovieDTO == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( imdbMovieDTO.size() );
        for ( ImdbMovieDTO imdbMovieDTO1 : imdbMovieDTO ) {
            list.add( toMovieDTOFromImdbMovieDTO( imdbMovieDTO1 ) );
        }

        return list;
    }
}
