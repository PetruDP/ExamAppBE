package com.imeghebe.jwt.backend.controllers;

import com.imeghebe.jwt.backend.dtos.MovieDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.facade.MovieFacade;
import com.imeghebe.jwt.backend.feign.ImdbClient;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/movie")
public class ImdbController {

    private final MovieFacade movieFacade;

    @GetMapping("/top100")
    public ResponseEntity<List<MovieDTO>> getTop100() {
        return ResponseEntity.ok(movieFacade.getTopMovies());
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getTop100(@PathVariable String movieId) {
        return ResponseEntity.ok(movieFacade.getMovieById(movieId));
    }

}
