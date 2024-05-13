package com.imeghebe.jwt.backend.services;

import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.User;

import java.util.List;

public interface UserService {

    User login(UserDTO credentialsDto);
    User register(User user);
    User findByUsername(String username);

    List<User> findAll();

    String encodePassword(String password);

    void save(User user);

    String extractUsername(String token);
}
