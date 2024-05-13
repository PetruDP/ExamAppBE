package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserOutputDTO;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.enums.RoleEnum;
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
public class UserOutputMapperImpl implements UserOutputMapper {

    @Override
    public UserOutputDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserOutputDTO.UserOutputDTOBuilder userOutputDTO = UserOutputDTO.builder();

        userOutputDTO.username( user.getUsername() );
        userOutputDTO.lastLoginDate( user.getLastLoginDate() );
        userOutputDTO.createdOn( user.getCreatedOn() );
        if ( user.getRole() != null ) {
            userOutputDTO.role( user.getRole().name() );
        }

        return userOutputDTO.build();
    }

    @Override
    public List<UserOutputDTO> toDto(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserOutputDTO> list = new ArrayList<UserOutputDTO>( user.size() );
        for ( User user1 : user ) {
            list.add( toDto( user1 ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserOutputDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getUsername() );
        if ( userDTO.getRole() != null ) {
            user.setRole( Enum.valueOf( RoleEnum.class, userDTO.getRole() ) );
        }
        user.setCreatedOn( userDTO.getCreatedOn() );
        user.setLastLoginDate( userDTO.getLastLoginDate() );

        return user;
    }

    @Override
    public List<User> toEntity(List<UserOutputDTO> userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTO.size() );
        for ( UserOutputDTO userOutputDTO : userDTO ) {
            list.add( toEntity( userOutputDTO ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(User entity, UserOutputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
        if ( dto.getRole() != null ) {
            entity.setRole( Enum.valueOf( RoleEnum.class, dto.getRole() ) );
        }
        if ( dto.getCreatedOn() != null ) {
            entity.setCreatedOn( dto.getCreatedOn() );
        }
        if ( dto.getLastLoginDate() != null ) {
            entity.setLastLoginDate( dto.getLastLoginDate() );
        }
    }
}
