package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dto.dtoPost.PostCreateDto;
import com.Dona.SozlukSitesi.dto.dtoPost.PostUpdateDto;
import com.Dona.SozlukSitesi.dto.dtoPost.PostViewDto;

import java.util.List;

public interface PostService {
    List<PostViewDto> getAllPosts();

    PostViewDto createPost(PostCreateDto newPost);

    PostViewDto getPostById(Long id);

    void deletePost(Long id);

    PostViewDto updatePost(Long id, PostUpdateDto postUpdateDto);
}
