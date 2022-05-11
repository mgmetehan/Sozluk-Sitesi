package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dto.dtoUser.UserCreateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateViewDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserViewDto;
import com.Dona.SozlukSitesi.service.UserService;
import com.Dona.SozlukSitesi.shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDto newUser) {
        userService.createUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateViewDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        final UserUpdateViewDto user = userService.updateUser(id, userUpdateDto);
        return ResponseEntity.ok(user);

      /*Farklı bir yol //Controller->public User updateOneUser

        public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setAvatar(newUser.getAvatar());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}
         */
    }

    @GetMapping("/activity/{userId}")
    public ResponseEntity<List<Object>> getUserLikesActivity(@PathVariable Long userId) {
        final List<Object> users = userService.getUserLikesActivity(userId);
        return ResponseEntity.ok(users);
    }
}
