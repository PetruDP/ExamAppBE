package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T14:55:16+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public UserDTO toDto(Admin user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( user.getUsername() );
        userDTO.password( user.getPassword() );

        return userDTO.build();
    }

    @Override
    public Admin toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setUsername( userDTO.getUsername() );
        admin.setPassword( userDTO.getPassword() );

        return admin;
    }
}
