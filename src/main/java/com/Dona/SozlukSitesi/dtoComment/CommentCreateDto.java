package com.Dona.SozlukSitesi.dtoComment;

import lombok.Data;

@Data
public class CommentCreateDto {

    private Long postId;
    private Long userId;
    private String userName;
    private String text;

    public CommentCreateDto(Long postId, Long userId, String userName, String text) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
    }
}
