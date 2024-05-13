package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserOutputDTO {

    private String username;
    private LocalDateTime lastLoginDate;
    private LocalDateTime createdOn;
    private String role;

}
