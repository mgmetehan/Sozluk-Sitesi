package com.Dona.SozlukSitesi.dto.dtoPost;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostCreateDto {
    private Long userId;

    @NotBlank(message = "Title cannot be null")
    @Size(min = 3, max = 20, message = "Title size must be between {min} and {max}")
    private String title;

    @NotBlank(message = "Text cannot be null")
    @Size(min = 5, max = 50, message = "Text size must be between {min} and {max}")
    private String text;

    public PostCreateDto(Long userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }
}
