package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoPost.PostCreateDto;
import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateDto newPost) {
        return ResponseEntity.ok(postService.createPost(newPost));
    }


}
