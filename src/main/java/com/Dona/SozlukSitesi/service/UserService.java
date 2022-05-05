package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dto.UserCreateDto;
import com.Dona.SozlukSitesi.dto.UserViewDto;
import com.Dona.SozlukSitesi.model.User;

import java.util.List;

public interface UserService {
    List<UserViewDto> getAllUsers();

    UserViewDto createUser(UserCreateDto newUser);

    UserViewDto getUserById(Long id);

    void deleteUser(Long id);
}
