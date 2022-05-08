package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoComment.CommentCreateDto;
import com.Dona.SozlukSitesi.dtoComment.CommentViewDto;
import com.Dona.SozlukSitesi.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/{comments}")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentViewDto>> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        final List<CommentViewDto> comments = commentService.getAllComments(userId, postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentCreateDto newComment) {
        return ResponseEntity.ok(commentService.createComment(newComment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentViewDto> getCommentById(@PathVariable("id") Long id) {
        CommentViewDto comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }
}
