package com.Dona.SozlukSitesi.dtoLike;

import com.Dona.SozlukSitesi.model.Like;
import lombok.Data;

@Data
public class LikeViewDto {
    private Long id;
    private Long userId;
    private Long postId;

    public LikeViewDto(Long id, Long userId, Long postId) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
    }

    public static LikeViewDto of(Like like) {
        return new LikeViewDto(like.getId(), like.getUser().getId(), like.getPost().getId());
    }

}
