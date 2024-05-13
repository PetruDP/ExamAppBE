package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserMovieDTO;
import com.imeghebe.jwt.backend.entites.UserMovie;
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
public class UserMovieMapperImpl implements UserMovieMapper {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public UserMovie toEntity(UserMovieDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserMovie userMovie = new UserMovie();

        userMovie.setMovie( movieMapper.toEntity( dto.getMovie() ) );
        userMovie.setMovieStatus( dto.getMovieStatus() );

        return userMovie;
    }

    @Override
    public UserMovieDTO toDto(UserMovie entity) {
        if ( entity == null ) {
            return null;
        }

        UserMovieDTO.UserMovieDTOBuilder userMovieDTO = UserMovieDTO.builder();

        userMovieDTO.movie( movieMapper.toDto( entity.getMovie() ) );
        userMovieDTO.movieStatus( entity.getMovieStatus() );

        return userMovieDTO.build();
    }

    @Override
    public List<UserMovie> toEntity(List<UserMovieDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserMovie> list = new ArrayList<UserMovie>( dtoList.size() );
        for ( UserMovieDTO userMovieDTO : dtoList ) {
            list.add( toEntity( userMovieDTO ) );
        }

        return list;
    }

    @Override
    public List<UserMovieDTO> toDto(List<UserMovie> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserMovieDTO> list = new ArrayList<UserMovieDTO>( entityList.size() );
        for ( UserMovie userMovie : entityList ) {
            list.add( toDto( userMovie ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(UserMovie entity, UserMovieDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getMovie() != null ) {
            entity.setMovie( movieMapper.toEntity( dto.getMovie() ) );
        }
        if ( dto.getMovieStatus() != null ) {
            entity.setMovieStatus( dto.getMovieStatus() );
        }
    }
}
