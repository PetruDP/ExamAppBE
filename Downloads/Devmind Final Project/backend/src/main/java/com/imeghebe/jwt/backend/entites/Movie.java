package com.imeghebe.jwt.backend.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "movie")
@Getter
@Setter
public class Movie {

    @Id
    private String id;

    private String title;

    private String description;

    private String link;

    @OneToMany
    private List<Director> director;

    @OneToMany
    private List<Writer> writers;

    @OneToMany
    private List<Star> stars;

    @OneToMany
    private List<Genre> genre;

    @OneToMany
    private List<Picture> images;

    private String imdbid;

    private double rank;

    private String rating;

    private String year;
}
