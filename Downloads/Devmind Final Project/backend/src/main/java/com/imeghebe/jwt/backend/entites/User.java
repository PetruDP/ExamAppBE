package com.imeghebe.jwt.backend.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "user_imgb")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
public class User extends Account {

    private LocalDateTime lastLoginDate;
}
