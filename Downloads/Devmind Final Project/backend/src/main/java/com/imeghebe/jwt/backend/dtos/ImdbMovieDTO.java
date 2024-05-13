package com.imeghebe.jwt.backend.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ImdbMovieDTO {

    private String id;
    private String title;
    private String description;
    private String link;
    private List<String> Director;
    private List<String> Writers;
    private List<String> Stars;
    private List<String> genre;
    private List<List<String>> images;
    private String imdbid;
    private double rank;
    private String rating;
    private String year;
}
