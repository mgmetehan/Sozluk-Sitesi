package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoComment.CommentViewDto;
import com.Dona.SozlukSitesi.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
