package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.User.UserPatchDto;
import com.federico.Ecommerce.dto.request.User.UserPutDto;
import com.federico.Ecommerce.dto.request.User.UserRequestDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody UserRequestDto dto) {

        UserResponseDto response = service.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> response = service.getAllUsers();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {

        UserResponseDto response = service.getUserById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Integer id,
            @RequestBody UserPutDto dto) {

        UserResponseDto response = service.updateUser(id, dto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> patchUser(
            @PathVariable Integer id,
            @RequestBody UserPatchDto dto) {

        UserResponseDto response = service.patchUser(id, dto);

        return ResponseEntity.ok(response);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUserById(@PathVariable Integer id) {

        UserResponseDto response = service.deleteUserById(id);

        return ResponseEntity.ok(response);
    }
}