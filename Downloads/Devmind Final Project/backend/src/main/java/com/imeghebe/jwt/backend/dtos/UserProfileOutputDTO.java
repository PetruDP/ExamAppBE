package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserProfileOutputDTO {

    private String username;

    private List<UserMovieDTO> userMovies;

}
