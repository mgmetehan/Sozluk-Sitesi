package com.Dona.SozlukSitesi.dto.dtoUser;

import com.Dona.SozlukSitesi.model.User;
import lombok.Data;

@Data
public class UserUpdateViewDto {

    private Long id;

    private String userName;

    private String password;

    public UserUpdateViewDto(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public static UserUpdateViewDto of(User user) {
        return new UserUpdateViewDto(user.getId(), user.getUserName(), user.getPassword());
    }
}