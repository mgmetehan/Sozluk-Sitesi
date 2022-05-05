package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoPost.PostViewDto;

import java.util.List;

public interface PostService {
    List<PostViewDto> getAllPosts();
}
