package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.PictureDTO;
import com.imeghebe.jwt.backend.entites.Picture;
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
public class PictureMapperImpl implements PictureMapper {

    @Override
    public List<PictureDTO> toDTO(List<Picture> images) {
        if ( images == null ) {
            return null;
        }

        List<PictureDTO> list = new ArrayList<PictureDTO>( images.size() );
        for ( Picture picture : images ) {
            list.add( toDTO( picture ) );
        }

        return list;
    }

    @Override
    public PictureDTO toDTO(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        PictureDTO.PictureDTOBuilder pictureDTO = PictureDTO.builder();

        pictureDTO.width( picture.getWidth() );
        pictureDTO.image( picture.getImage() );

        return pictureDTO.build();
    }

    @Override
    public Picture toEntity(PictureDTO pictureDTO) {
        if ( pictureDTO == null ) {
            return null;
        }

        Picture picture = new Picture();

        picture.setWidth( pictureDTO.getWidth() );
        picture.setImage( pictureDTO.getImage() );

        return picture;
    }

    @Override
    public List<Picture> toEntity(List<PictureDTO> pictureDTOS) {
        if ( pictureDTOS == null ) {
            return null;
        }

        List<Picture> list = new ArrayList<Picture>( pictureDTOS.size() );
        for ( PictureDTO pictureDTO : pictureDTOS ) {
            list.add( toEntity( pictureDTO ) );
        }

        return list;
    }
}
