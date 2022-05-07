package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoLike.LikeCreateDto;
import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeViewDto> getAllLikes(Optional<Long> postId, Optional<Long> userId);

    LikeViewDto createLike(LikeCreateDto likeCreateDto);

    LikeViewDto getLikeById(Long likeId);

    void deleteLike(Long likeId);
}
