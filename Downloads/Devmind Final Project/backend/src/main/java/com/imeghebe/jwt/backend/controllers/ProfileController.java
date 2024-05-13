package com.imeghebe.jwt.backend.controllers;

import com.imeghebe.jwt.backend.dtos.MovieStatusDTO;
import com.imeghebe.jwt.backend.dtos.UpdateUserInputDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.dtos.UserProfileOutputDTO;
import com.imeghebe.jwt.backend.facade.UserFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final UserFacade userFacade;


    @PostMapping("/update")
    public ResponseEntity<UserDTO> updateUserProfile(@RequestBody @Valid UpdateUserInputDTO userDto,
                                                    @RequestHeader("Authorization") String token) {
        UserDTO userDTO = userFacade.updateUser(token, userDto);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserProfileOutputDTO> getUserProfile(@PathVariable String username) {
        return ResponseEntity.ok(userFacade.getUserProfile(username));
    }

    @PostMapping("/add/{movieId}")
    public ResponseEntity<Void> addMovie(@RequestHeader("Authorization") String token,
                                                         @PathVariable String movieId) {
        userFacade.addUserMovie(token, movieId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove/{movieId}")
    public ResponseEntity<Void> removeMovie(@PathVariable String movieId,
                                            @RequestHeader("Authorization") String token) {
        userFacade.removeUserMovie(token, movieId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/movie")
    public ResponseEntity<Void> updateMovie(@RequestBody @Valid MovieStatusDTO movieStatusDTO,
                                            @RequestHeader("Authorization") String token) {
        userFacade.updateMovieStatusForUser(token, movieStatusDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
