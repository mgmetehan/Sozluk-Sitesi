package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dto.UserCreateDto;
import com.Dona.SozlukSitesi.dto.UserUpdateDto;
import com.Dona.SozlukSitesi.dto.UserUpdateViewDto;
import com.Dona.SozlukSitesi.dto.UserViewDto;

import java.util.List;

public interface UserService {
    List<UserViewDto> getAllUsers();

    UserViewDto createUser(UserCreateDto newUser);

    UserViewDto getUserById(Long id);

    void deleteUser(Long id);

    UserUpdateViewDto updateUser(Long id, UserUpdateDto userUpdateDto);
}
