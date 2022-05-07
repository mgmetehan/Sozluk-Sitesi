package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoLike.LikeCreateDto;
import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;

import java.util.List;

public interface LikeService {
    List<LikeViewDto> getAllLikes();

    LikeViewDto createLike(LikeCreateDto likeCreateDto);

    LikeViewDto getLikeById(Long likeId);

    void deleteLike(Long likeId);
}
