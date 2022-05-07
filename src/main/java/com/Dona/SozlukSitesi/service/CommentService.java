package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoComment.CommentViewDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentViewDto> getAllComments(Optional<Long> userId, Optional<Long> postId);
}
