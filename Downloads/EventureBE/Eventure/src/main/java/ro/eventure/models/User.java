package ro.eventure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "user")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
public class User extends Account {

    private String phoneNumber;

    private String name;

    private LocalDateTime lastLoginDate;

    private Short avgRating = 0;

    @Column(unique = true)
    private String identityNumber;
}
