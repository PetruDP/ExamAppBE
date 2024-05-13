package com.imeghebe.jwt.backend.facade;

import com.imeghebe.jwt.backend.dtos.MovieStatusDTO;
import com.imeghebe.jwt.backend.dtos.UpdateUserInputDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.dtos.UserProfileOutputDTO;

public interface UserFacade {
    UserDTO updateUser(String token, UpdateUserInputDTO userDto);

    UserProfileOutputDTO getUserProfile(String username);

    void addUserMovie(String token, String movieId);

    void removeUserMovie(String token, String movieId);

    void updateMovieStatusForUser(String token, MovieStatusDTO movieStatusDTO);
}
