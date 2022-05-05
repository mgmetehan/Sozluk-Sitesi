package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dto.UserCreateDto;
import com.Dona.SozlukSitesi.dto.UserViewDto;
import com.Dona.SozlukSitesi.model.User;
import com.Dona.SozlukSitesi.service.UserService;
import com.Dona.SozlukSitesi.shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserViewDto>> getAllUsers() {
        final List<UserViewDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreateDto newUser) {
        userService.createUser(newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDto> getUserById(@PathVariable("id") Long id) {
        UserViewDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }


}
