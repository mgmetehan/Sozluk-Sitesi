package com.Dona.SozlukSitesi.dtoPost;

import lombok.Data;

@Data
public class PostCreateDto {
    private Long userId;
    private String title;
    private String text;

    public PostCreateDto(Long userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }
}
