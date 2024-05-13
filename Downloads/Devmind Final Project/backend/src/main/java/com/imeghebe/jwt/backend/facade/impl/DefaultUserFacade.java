package com.imeghebe.jwt.backend.facade.impl;

import com.imeghebe.jwt.backend.config.UserAuthenticationProvider;
import com.imeghebe.jwt.backend.dtos.*;
import com.imeghebe.jwt.backend.entites.Movie;
import com.imeghebe.jwt.backend.entites.User;
import com.imeghebe.jwt.backend.entites.UserMovie;
import com.imeghebe.jwt.backend.facade.UserFacade;
import com.imeghebe.jwt.backend.mappers.UpdateUserMapper;
import com.imeghebe.jwt.backend.mappers.UserMapper;
import com.imeghebe.jwt.backend.mappers.UserMovieMapper;
import com.imeghebe.jwt.backend.services.MovieService;
import com.imeghebe.jwt.backend.services.UserMovieService;
import com.imeghebe.jwt.backend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {

    private final UserService userService;
    private final UserMovieService userMovieService;
    private final MovieService movieService;
    private final UpdateUserMapper updateUserMapper;
    private final UserMapper userMapper;
    private final UserMovieMapper userMovieMapper;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Override
    @Transactional
    public UserDTO updateUser(String token, UpdateUserInputDTO userDto) {
        String username = userService.extractUsername(token);
        User user = userService.findByUsername(username);

        if (!Objects.isNull(userDto.getOldPassword())){
        user = userService.login(UserDTO.builder()
                .password(userDto.getOldPassword())
                .username(username)
                .build());
            updateUserMapper.partialUpdate(user, userDto);
            user.setPassword(userService.encodePassword(userDto.getNewPassword()));
        }else{
          updateUserMapper.partialUpdate(user, userDto);
        }

        userService.save(user);
        UserDTO userDTO = userMapper.toDto(user);
        userDTO.setToken(userAuthenticationProvider.createToken(userDTO.getUsername(), user.getRole()));

        return userDTO;
    }

    @Override
    @Transactional
    public UserProfileOutputDTO getUserProfile(String username) {
        List<UserMovieDTO> userMovieDTOS = userMovieMapper.toDto(userMovieService.getMoviesForUser(userService.findByUsername(username).getId()));

        return UserProfileOutputDTO.builder()
                .userMovies(userMovieDTOS)
                .username(username)
                .build();
    }

    @Override
    @Transactional
    public void addUserMovie(String token, String movieId) {
        User user = userService.findByUsername(userService.extractUsername(token));
        for(UserMovie movie : userMovieService.getMoviesForUser(user.getId())){
            if (movie.getMovie().getId().equals(movieId)){
                return;
            }
        }
        UserMovie userMovie = new UserMovie();
        userMovie.setUser(user);
        userMovie.setMovie(movieService.findById(movieId));
        userMovieService.save(userMovie);
    }

    @Override
    @Transactional
    public void removeUserMovie(String token, String movieId) {
        User user = userService.findByUsername(userService.extractUsername(token));
        userMovieService.removeUserMovie(user.getId(), movieId);
    }

    @Override
    @Transactional
    public void updateMovieStatusForUser(String token, MovieStatusDTO movieStatusDTO) {
        User user = userService.findByUsername(userService.extractUsername(token));
        userMovieService.updateMovieStatus(user.getId(), movieStatusDTO);
    }
}
