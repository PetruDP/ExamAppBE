package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UserOutputDTO;
import com.imeghebe.jwt.backend.entites.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserOutputMapper {

    UserOutputDTO toDto(User user);
    List<UserOutputDTO> toDto(List<User> user);

    User toEntity(UserOutputDTO userDTO);
    List<User> toEntity(List<UserOutputDTO> userDTO);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget User entity, UserOutputDTO dto);
}
