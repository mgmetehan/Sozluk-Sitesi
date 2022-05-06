package com.Dona.SozlukSitesi.dtoUser;

import lombok.Data;

@Data
public class UserCreateDto {
    private String userName;

    private String password;

    public UserCreateDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}