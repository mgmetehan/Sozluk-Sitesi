package com.Dona.SozlukSitesi.dto;

import com.Dona.SozlukSitesi.model.User;
import lombok.Data;

@Data
public class UserViewDto {

    private final String userName;

    public UserViewDto(String userName) {
        this.userName = userName;
    }

    public static UserViewDto of(User user) {
        return new UserViewDto(user.getUserName());
    }
}
