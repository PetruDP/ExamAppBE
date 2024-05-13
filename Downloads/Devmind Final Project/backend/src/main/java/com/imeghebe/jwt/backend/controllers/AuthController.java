package com.imeghebe.jwt.backend.controllers;


import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.facade.AuthFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/authentication")
public class AuthController {

    private final AuthFacade authFacade;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid UserDTO userDto) {
        UserDTO userDTO = authFacade.login(userDto);

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO userDto) {
        UserDTO userDTO = authFacade.register(userDto);

        return ResponseEntity.ok(userDTO);
    }

}
