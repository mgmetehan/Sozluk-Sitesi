package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dtoComment.CommentViewDto;
import com.Dona.SozlukSitesi.model.Comment;
import com.Dona.SozlukSitesi.repository.CommentRepository;
import com.Dona.SozlukSitesi.service.CommentService;
import com.Dona.SozlukSitesi.service.PostService;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<CommentViewDto> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> list;
        if (userId.isPresent()) {//http://localhost:8088/comments?userId=2  kullanimi
            list = commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            list = commentRepository.findByPostId(postId.get());
        } else {
            list = commentRepository.findAll();
        }
        return list.stream().map(CommentViewDto::of).collect(Collectors.toList());
    }
}
