package com.imeghebe.jwt.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import static com.imeghebe.jwt.backend.config.Constants.PASSWORD_PATTERN;
import static com.imeghebe.jwt.backend.config.Constants.USERNAME_PATTERN;

@Data
@Builder
public class UserDTO {

    @NotBlank(message = "username cannot be null or empty")
    @Pattern(regexp = USERNAME_PATTERN, message = "Name must contain only letters, may include '.' or '-' and should not exceed 50 characters.")
    private String username;

    @NotNull(message = "Password must not be null")
    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Parola trebuie sa contina minim 8 caractere, min 1 litera majuscula, min 1 litera mica, min o cifra si min un caracter special!")
    private String password;

    private String token;

}
