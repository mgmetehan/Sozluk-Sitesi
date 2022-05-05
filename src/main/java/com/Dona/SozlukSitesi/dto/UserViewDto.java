package com.Dona.SozlukSitesi.dto;

import com.Dona.SozlukSitesi.model.User;
import lombok.Data;

@Data
public class UserViewDto {

    private Long id;
    private String userName;

    public UserViewDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public static UserViewDto of(User user) {
        return new UserViewDto(user.getId(), user.getUserName());
    }
}
