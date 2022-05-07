package com.Dona.SozlukSitesi.controller;

import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;
import com.Dona.SozlukSitesi.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public ResponseEntity<List<LikeViewDto>> getAllLikes(){
        final List<LikeViewDto> likes=likeService.getAllLikes();
        return ResponseEntity.ok(likes);
    }
}
