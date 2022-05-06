package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostViewDto>> getAllPosts() {
        final List<PostViewDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

}
