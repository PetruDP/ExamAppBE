package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PictureDTO {
    private String width;
    private String image;
}
