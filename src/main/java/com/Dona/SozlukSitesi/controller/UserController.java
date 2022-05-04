package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dto.UserViewDto;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
