package com.Dona.SozlukSitesi.dtoComment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CommentCreateDto {
    private Long postId;

    private Long userId;

    @NotBlank(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = "User Name size must be between {min} and {max}")
    private String userName;

    @NotBlank(message = "Text cannot be null")
    @Size(min = 5, max = 50, message = "Text size must be between {min} and {max}")
    private String text;

    public CommentCreateDto(Long postId, Long userId, String userName, String text) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
    }
}
