package com.example.dtomapstruct.controller;

import com.example.dtomapstruct.dto.UserDto;
import com.example.dtomapstruct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
        UserDto createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUserById(@RequestParam String id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(Long.valueOf(id)));
    }
    @GetMapping("/m")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) throws Exception {
        return ResponseEntity.ok(userService.getUserByUsername(email));
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> updateUser(@RequestParam String id, @RequestBody UserDto userDTO) throws Exception {
        return ResponseEntity.ok(userService.updateUser(Long.valueOf(id), userDTO));
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}

