package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserMovieDTO;
import com.imeghebe.jwt.backend.entites.UserMovie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MovieMapper.class})
public interface UserMovieMapper extends EntityMapper<UserMovieDTO, UserMovie>{
}
