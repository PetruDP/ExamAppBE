package com.imeghebe.jwt.backend.services.impl;

import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Admin;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.exceptions.AppException;
import com.imeghebe.jwt.backend.repositories.AdminRepository;
import com.imeghebe.jwt.backend.services.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class DefaultAdminService implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Admin login(UserDTO userDTO) {
        Admin admin = adminRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(userDTO.getPassword()), admin.getPassword())) {
            return admin;
        } else {
            throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public Admin save(Admin admin) {
        admin.setPassword(passwordEncoder.encode(CharBuffer.wrap(admin.getPassword())));
        return adminRepository.save(admin);
    }
}
