package com.imeghebe.jwt.backend.services.impl;

import com.imeghebe.jwt.backend.config.UserAuthenticationProvider;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.exceptions.AppException;
import com.imeghebe.jwt.backend.repositories.UserRepository;
import com.imeghebe.jwt.backend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public User login(UserDTO userDto) {
        User user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(userDto.getPassword()), user.getPassword())) {
            return user;
        } else {
            throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
        }
    }

    public User register(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("User already exists", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(encodePassword(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAllByOrderById();
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(CharBuffer.wrap(password));
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public String extractUsername(String token) {
        return userAuthenticationProvider.extractUsername(token);
    }

}
