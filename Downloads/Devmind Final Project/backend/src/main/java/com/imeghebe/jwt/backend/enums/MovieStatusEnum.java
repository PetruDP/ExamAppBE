package com.imeghebe.jwt.backend.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovieStatusEnum {

    NOT_WATCHED("NOT WATCHED"),
    WATCHED("WATCHED");

    private final String value;
}
