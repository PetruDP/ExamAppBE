package com.imeghebe.jwt.backend.mappers;

import com.imeghebe.jwt.backend.dtos.UpdateUserInputDTO;
import com.imeghebe.jwt.backend.entites.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper extends EntityMapper<UpdateUserInputDTO, User>{

}
