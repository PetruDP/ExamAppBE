package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UpdateUserInputDTO;
import com.imeghebe.jwt.backend.entites.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T14:55:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class UpdateUserMapperImpl implements UpdateUserMapper {

    @Override
    public User toEntity(UpdateUserInputDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.getUsername() );

        return user;
    }

    @Override
    public UpdateUserInputDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UpdateUserInputDTO.UpdateUserInputDTOBuilder updateUserInputDTO = UpdateUserInputDTO.builder();

        updateUserInputDTO.username( entity.getUsername() );

        return updateUserInputDTO.build();
    }

    @Override
    public List<User> toEntity(List<UpdateUserInputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UpdateUserInputDTO updateUserInputDTO : dtoList ) {
            list.add( toEntity( updateUserInputDTO ) );
        }

        return list;
    }

    @Override
    public List<UpdateUserInputDTO> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UpdateUserInputDTO> list = new ArrayList<UpdateUserInputDTO>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(User entity, UpdateUserInputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
    }
}
