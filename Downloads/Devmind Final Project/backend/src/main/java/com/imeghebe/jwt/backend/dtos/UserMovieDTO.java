package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserMovieDTO {

    private MovieDTO movie;
    private String movieStatus;
}
