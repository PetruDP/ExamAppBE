package com.imeghebe.jwt.backend.dtos;

import com.imeghebe.jwt.backend.entites.Director;
import com.imeghebe.jwt.backend.entites.Genre;
import com.imeghebe.jwt.backend.entites.Star;
import com.imeghebe.jwt.backend.entites.Writer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieDTO {

    private String id;
    private String title;
    private String description;
    private String link;
    private List<Director> director;
    private List<Writer> writers;
    private List<Star> stars;
    private List<Genre> genre;
    private List<PictureDTO> images;
    private String imdbid;
    private double rank;
    private String rating;
    private String year;
}
