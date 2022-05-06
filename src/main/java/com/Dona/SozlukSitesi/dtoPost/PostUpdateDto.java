package com.Dona.SozlukSitesi.dtoPost;

import lombok.Data;

@Data
public class PostUpdateDto {

    private String title;
    private String text;

    public PostUpdateDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
