package com.imeghebe.jwt.backend.facade;

import com.imeghebe.jwt.backend.dtos.UserDTO;

public interface AuthFacade {

    UserDTO login(UserDTO credentialsDto);
    UserDTO register(UserDTO signUpDto);
    UserDTO findByUsername(String subject);
}
