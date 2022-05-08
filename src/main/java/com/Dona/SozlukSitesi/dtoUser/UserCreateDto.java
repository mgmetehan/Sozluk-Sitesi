package com.Dona.SozlukSitesi.dtoUser;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserCreateDto {
    @NotBlank(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = "User Name size must be between {min} and {max}")
    private String userName;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 4, max = 15, message = "Password size must be between {min} and {max}")
    private String password;

    public UserCreateDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
