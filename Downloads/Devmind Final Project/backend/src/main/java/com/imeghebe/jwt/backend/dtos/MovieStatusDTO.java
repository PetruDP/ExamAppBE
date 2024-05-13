package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieStatusDTO {

    private String movieId;
    private String movieStatus;
}
