package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoLike.LikeCreateDto;
import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;
import com.Dona.SozlukSitesi.service.LikeService;
import com.Dona.SozlukSitesi.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public ResponseEntity<List<LikeViewDto>> getAllLikes(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
        final List<LikeViewDto> likes = likeService.getAllLikes(postId, userId);
        return ResponseEntity.ok(likes);
    }

    @PostMapping
    public ResponseEntity<?> createLike(@RequestBody LikeCreateDto likeCreateDto) {
        return ResponseEntity.ok(likeService.createLike(likeCreateDto));
    }

    @GetMapping("/{likeId}")
    public ResponseEntity<LikeViewDto> getLikeById(@PathVariable("likeId") Long likeId) {
        LikeViewDto like = likeService.getLikeById(likeId);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<?> deleteLike(@PathVariable("likeId") Long likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.ok(new GenericResponse("Like Deleted"));
    }
}
