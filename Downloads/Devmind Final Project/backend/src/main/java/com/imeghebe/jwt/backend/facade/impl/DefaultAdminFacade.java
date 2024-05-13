package com.imeghebe.jwt.backend.facade.impl;

import com.imeghebe.jwt.backend.dtos.UserOutputDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Admin;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.enums.RoleEnum;
import com.imeghebe.jwt.backend.facade.AdminFacade;
import com.imeghebe.jwt.backend.mappers.AdminMapper;
import com.imeghebe.jwt.backend.mappers.UserOutputMapper;
import com.imeghebe.jwt.backend.services.AdminService;
import com.imeghebe.jwt.backend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultAdminFacade implements AdminFacade {

    private final UserService userService;
    private final AdminService adminService;
    private final UserOutputMapper userOutputMapper;
    private final AdminMapper adminMapper;

    @Override
    @Transactional
    public List<UserOutputDTO> getUsers() {
        return userOutputMapper.toDto(userService.findAll());
    }

    @Override
    @Transactional
    public UserDTO createAdmin(UserDTO userDTO) {
        Admin admin = adminMapper.toEntity(userDTO);
        admin.setRole(RoleEnum.ADMIN.getValue());
        return adminMapper.toDto(adminService.save(admin));
    }

    @Override
    @Transactional
    public UserOutputDTO getUser(String username) {
        return userOutputMapper.toDto(userService.findByUsername(username));
    }

    @Override
    @Transactional
    public UserOutputDTO update(UserOutputDTO userOutputDTO) {
        User user = userService.findByUsername(userOutputDTO.getUsername());

        userOutputMapper.partialUpdate(user, userOutputDTO);
        userService.save(user);
        return userOutputDTO;
    }
}
