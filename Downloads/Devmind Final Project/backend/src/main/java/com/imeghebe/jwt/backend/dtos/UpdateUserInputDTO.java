package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserInputDTO {

    private String username;
    private String oldPassword;
    private String newPassword;
}
