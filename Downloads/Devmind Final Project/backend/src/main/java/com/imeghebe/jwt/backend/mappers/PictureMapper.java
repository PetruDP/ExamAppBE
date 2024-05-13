package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.PictureDTO;
import com.imeghebe.jwt.backend.entites.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    List<PictureDTO> toDTO(List<Picture> images);
    PictureDTO toDTO(Picture picture);
    Picture toEntity(PictureDTO pictureDTO);
    List<Picture> toEntity(List<PictureDTO> pictureDTOS);
}
