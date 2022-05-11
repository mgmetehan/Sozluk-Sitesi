package com.Dona.SozlukSitesi.dto.dtoLike;

import lombok.Data;

@Data
public class LikeCreateDto {
    private Long id;

    private Long userId;

    private Long postId;

    public LikeCreateDto(Long id, Long userId, Long postId) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
    }
}
