package com.imeghebe.jwt.backend.mappers;


import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    List<UserDTO> toDto(List<User> user);

    User toEntity(UserDTO userDTO);
    List<User> toEntity(List<UserDTO> userDTO);

}
