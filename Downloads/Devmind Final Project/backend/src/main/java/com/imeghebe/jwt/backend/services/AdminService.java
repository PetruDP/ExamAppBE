package com.imeghebe.jwt.backend.services;

import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Admin;

public interface AdminService {

    Admin login(UserDTO userDTO);

    Admin save(Admin admin);
}
