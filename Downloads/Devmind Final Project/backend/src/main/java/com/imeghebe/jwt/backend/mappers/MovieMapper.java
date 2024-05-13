package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.MovieDTO;
import com.imeghebe.jwt.backend.entites.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PictureMapper.class})
public interface MovieMapper extends EntityMapper<MovieDTO, Movie>{
}
