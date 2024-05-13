package com.imeghebe.jwt.backend.entites;

import com.imeghebe.jwt.backend.enums.MovieStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_movie")
@Getter
@Setter
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String movieStatus = MovieStatusEnum.NOT_WATCHED.getValue();
}
