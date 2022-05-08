package com.Dona.SozlukSitesi.service;

import com.Dona.SozlukSitesi.dtoComment.CommentCreateDto;
import com.Dona.SozlukSitesi.dtoComment.CommentUpdateDto;
import com.Dona.SozlukSitesi.dtoComment.CommentViewDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentViewDto> getAllComments(Optional<Long> userId, Optional<Long> postId);

    CommentViewDto createComment(CommentCreateDto newComment);

    CommentViewDto getCommentById(Long id);

    void deleteComment(Long id);

    CommentViewDto updateComment(Long id, CommentUpdateDto commentUpdateDto);
}
