package com.imeghebe.jwt.backend.config;

public final class Constants {
    public static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,32}$";
    public static final String USERNAME_PATTERN = "^[a-zA-Z ]{2,}$";
}
