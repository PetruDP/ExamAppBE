package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.MovieDTO;
import com.imeghebe.jwt.backend.entites.Director;
import com.imeghebe.jwt.backend.entites.Genre;
import com.imeghebe.jwt.backend.entites.Movie;
import com.imeghebe.jwt.backend.entites.Picture;
import com.imeghebe.jwt.backend.entites.Star;
import com.imeghebe.jwt.backend.entites.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T14:55:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public Movie toEntity(MovieDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( dto.getId() );
        movie.setTitle( dto.getTitle() );
        movie.setDescription( dto.getDescription() );
        movie.setLink( dto.getLink() );
        List<Director> list = dto.getDirector();
        if ( list != null ) {
            movie.setDirector( new ArrayList<Director>( list ) );
        }
        List<Writer> list1 = dto.getWriters();
        if ( list1 != null ) {
            movie.setWriters( new ArrayList<Writer>( list1 ) );
        }
        List<Star> list2 = dto.getStars();
        if ( list2 != null ) {
            movie.setStars( new ArrayList<Star>( list2 ) );
        }
        List<Genre> list3 = dto.getGenre();
        if ( list3 != null ) {
            movie.setGenre( new ArrayList<Genre>( list3 ) );
        }
        movie.setImages( pictureMapper.toEntity( dto.getImages() ) );
        movie.setImdbid( dto.getImdbid() );
        movie.setRank( dto.getRank() );
        movie.setRating( dto.getRating() );
        movie.setYear( dto.getYear() );

        return movie;
    }

    @Override
    public MovieDTO toDto(Movie entity) {
        if ( entity == null ) {
            return null;
        }

        MovieDTO.MovieDTOBuilder movieDTO = MovieDTO.builder();

        movieDTO.id( entity.getId() );
        movieDTO.title( entity.getTitle() );
        movieDTO.description( entity.getDescription() );
        movieDTO.link( entity.getLink() );
        List<Director> list = entity.getDirector();
        if ( list != null ) {
            movieDTO.director( new ArrayList<Director>( list ) );
        }
        List<Writer> list1 = entity.getWriters();
        if ( list1 != null ) {
            movieDTO.writers( new ArrayList<Writer>( list1 ) );
        }
        List<Star> list2 = entity.getStars();
        if ( list2 != null ) {
            movieDTO.stars( new ArrayList<Star>( list2 ) );
        }
        List<Genre> list3 = entity.getGenre();
        if ( list3 != null ) {
            movieDTO.genre( new ArrayList<Genre>( list3 ) );
        }
        movieDTO.images( pictureMapper.toDTO( entity.getImages() ) );
        movieDTO.imdbid( entity.getImdbid() );
        movieDTO.rank( entity.getRank() );
        movieDTO.rating( entity.getRating() );
        movieDTO.year( entity.getYear() );

        return movieDTO.build();
    }

    @Override
    public List<Movie> toEntity(List<MovieDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( dtoList.size() );
        for ( MovieDTO movieDTO : dtoList ) {
            list.add( toEntity( movieDTO ) );
        }

        return list;
    }

    @Override
    public List<MovieDTO> toDto(List<Movie> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( entityList.size() );
        for ( Movie movie : entityList ) {
            list.add( toDto( movie ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Movie entity, MovieDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getLink() != null ) {
            entity.setLink( dto.getLink() );
        }
        if ( entity.getDirector() != null ) {
            List<Director> list = dto.getDirector();
            if ( list != null ) {
                entity.getDirector().clear();
                entity.getDirector().addAll( list );
            }
        }
        else {
            List<Director> list = dto.getDirector();
            if ( list != null ) {
                entity.setDirector( new ArrayList<Director>( list ) );
            }
        }
        if ( entity.getWriters() != null ) {
            List<Writer> list1 = dto.getWriters();
            if ( list1 != null ) {
                entity.getWriters().clear();
                entity.getWriters().addAll( list1 );
            }
        }
        else {
            List<Writer> list1 = dto.getWriters();
            if ( list1 != null ) {
                entity.setWriters( new ArrayList<Writer>( list1 ) );
            }
        }
        if ( entity.getStars() != null ) {
            List<Star> list2 = dto.getStars();
            if ( list2 != null ) {
                entity.getStars().clear();
                entity.getStars().addAll( list2 );
            }
        }
        else {
            List<Star> list2 = dto.getStars();
            if ( list2 != null ) {
                entity.setStars( new ArrayList<Star>( list2 ) );
            }
        }
        if ( entity.getGenre() != null ) {
            List<Genre> list3 = dto.getGenre();
            if ( list3 != null ) {
                entity.getGenre().clear();
                entity.getGenre().addAll( list3 );
            }
        }
        else {
            List<Genre> list3 = dto.getGenre();
            if ( list3 != null ) {
                entity.setGenre( new ArrayList<Genre>( list3 ) );
            }
        }
        if ( entity.getImages() != null ) {
            List<Picture> list4 = pictureMapper.toEntity( dto.getImages() );
            if ( list4 != null ) {
                entity.getImages().clear();
                entity.getImages().addAll( list4 );
            }
        }
        else {
            List<Picture> list4 = pictureMapper.toEntity( dto.getImages() );
            if ( list4 != null ) {
                entity.setImages( list4 );
            }
        }
        if ( dto.getImdbid() != null ) {
            entity.setImdbid( dto.getImdbid() );
        }
        entity.setRank( dto.getRank() );
        if ( dto.getRating() != null ) {
            entity.setRating( dto.getRating() );
        }
        if ( dto.getYear() != null ) {
            entity.setYear( dto.getYear() );
        }
    }
}
