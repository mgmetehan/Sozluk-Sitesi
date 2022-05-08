package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoPost.PostCreateDto;
import com.Dona.SozlukSitesi.dtoPost.PostUpdateDto;
import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.service.PostService;
import com.Dona.SozlukSitesi.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> createPost(@Valid @RequestBody PostCreateDto newPost) {
        return ResponseEntity.ok(postService.createPost(newPost));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostViewDto> getPostById(@PathVariable("id") Long id) {
        PostViewDto post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok(new GenericResponse("Post Deleted"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostViewDto> updatePost(@PathVariable("id") Long id, @Valid @RequestBody PostUpdateDto postUpdateDto) {
        final PostViewDto post = postService.updatePost(id, postUpdateDto);
        return ResponseEntity.ok(post);
    }
}
