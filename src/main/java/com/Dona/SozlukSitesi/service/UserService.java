package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dto.dtoUser.UserCreateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateViewDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserViewDto;

import java.util.List;

public interface UserService {
    List<UserViewDto> getAllUsers();

    UserViewDto createUser(UserCreateDto newUser);

    UserViewDto getUserById(Long id);

    void deleteUser(Long id);

    UserUpdateViewDto updateUser(Long id, UserUpdateDto userUpdateDto);

    List<Object> getUserLikesActivity(Long userId);
}
