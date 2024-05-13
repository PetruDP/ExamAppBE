package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    UserDTO toDto(Admin user);

    Admin toEntity(UserDTO userDTO);

}