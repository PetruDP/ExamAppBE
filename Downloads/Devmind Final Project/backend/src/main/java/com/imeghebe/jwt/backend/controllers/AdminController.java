package com.imeghebe.jwt.backend.controllers;

import com.imeghebe.jwt.backend.dtos.UserOutputDTO;
import com.imeghebe.jwt.backend.dtos.UserDTO;
import com.imeghebe.jwt.backend.facade.AdminFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminFacade adminFacade;

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserOutputDTO>> getUsers() {
        return ResponseEntity.ok(adminFacade.getUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createAdmin(@RequestBody @Valid UserDTO adminDTO) {
        return ResponseEntity.ok(adminFacade.createAdmin(adminDTO));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserOutputDTO> getUser(@PathVariable String username) {
        return ResponseEntity.ok(adminFacade.getUser(username));
    }

    @PostMapping("/update")
    public ResponseEntity<UserOutputDTO> update(@RequestBody UserOutputDTO userOutputDTO) {
        return ResponseEntity.ok(adminFacade.update(userOutputDTO));
    }
}
