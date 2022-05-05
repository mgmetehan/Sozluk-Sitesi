package com.Dona.SozlukSitesi.dto;

import lombok.Data;

@Data
public class UserUpdateDto {

    private String userName;
    private String password;

    public UserUpdateDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
