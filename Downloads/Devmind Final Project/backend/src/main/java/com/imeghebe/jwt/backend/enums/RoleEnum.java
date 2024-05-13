package com.imeghebe.jwt.backend.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleEnum {

    ADMIN("ADMIN"),
    USER("USER");

    private final String value;
}
