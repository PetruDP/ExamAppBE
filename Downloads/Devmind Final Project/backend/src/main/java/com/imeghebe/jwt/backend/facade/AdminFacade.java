package com.imeghebe.jwt.backend.facade;

import com.imeghebe.jwt.backend.dtos.UserOutputDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;

import java.util.List;

public interface AdminFacade {

    List<UserOutputDTO> getUsers();

    UserDTO createAdmin(UserDTO userDTO);

    UserOutputDTO getUser(String username);

    UserOutputDTO update(UserOutputDTO userOutputDTO);
}
