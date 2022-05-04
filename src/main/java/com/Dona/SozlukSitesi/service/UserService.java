package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dto.UserViewDto;

import java.util.List;

public interface UserService {
    List<UserViewDto> getAllUsers();
}
