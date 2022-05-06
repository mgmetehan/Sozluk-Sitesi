package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoUser.UserCreateDto;
import com.Dona.SozlukSitesi.dtoUser.UserUpdateDto;
import com.Dona.SozlukSitesi.dtoUser.UserUpdateViewDto;
import com.Dona.SozlukSitesi.dtoUser.UserViewDto;

import java.util.List;

public interface UserService {
    List<UserViewDto> getAllUsers();

    UserViewDto createUser(UserCreateDto newUser);

    UserViewDto getUserById(Long id);

    void deleteUser(Long id);

    UserUpdateViewDto updateUser(Long id, UserUpdateDto userUpdateDto);
}
