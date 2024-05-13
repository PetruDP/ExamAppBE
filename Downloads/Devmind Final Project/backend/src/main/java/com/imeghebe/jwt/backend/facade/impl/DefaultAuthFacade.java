package com.imeghebe.jwt.backend.facade.impl;

import com.imeghebe.jwt.backend.config.UserAuthenticationProvider;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.Account;
import com.imeghebe.jwt.backend.entites.Admin;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.enums.RoleEnum;
import com.imeghebe.jwt.backend.facade.AuthFacade;
import com.imeghebe.jwt.backend.mappers.AdminMapper;
import com.imeghebe.jwt.backend.mappers.UserMapper;
import com.imeghebe.jwt.backend.services.AccountService;
import com.imeghebe.jwt.backend.services.AdminService;
import com.imeghebe.jwt.backend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DefaultAuthFacade implements AuthFacade {

    private final UserAuthenticationProvider userAuthenticationProvider;
    private final UserService userService;
    private final UserMapper userMapper;
    private final AdminMapper adminMapper;
    private final AccountService accountService;
    private final AdminService adminService;


    @Override
    @Transactional
    public UserDTO login(UserDTO userDTO) {
        Account account = accountService.findByUsername(userDTO.getUsername());

        if (account instanceof User) {
            User user = userService.login(userDTO);
            userDTO = userMapper.toDto(user);
            userDTO.setToken(userAuthenticationProvider.createToken(userDTO.getUsername(), account.getRole()));

        } else if (account instanceof Admin) {
            Admin admin = adminService.login(userDTO);
            userDTO = adminMapper.toDto(admin);
            userDTO.setToken(userAuthenticationProvider.createToken(userDTO.getUsername(),  account.getRole()));
        }

        return userDTO;
    }

    @Override
    @Transactional
    public UserDTO register(UserDTO userDTO) {
        userService.register(userMapper.toEntity(userDTO));
        userDTO.setToken(userAuthenticationProvider.createToken(userDTO.getUsername(), RoleEnum.USER.getValue()));

        return userDTO;
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.toDto(userService.findByUsername(username));
    }
}
