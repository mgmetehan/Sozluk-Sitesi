package com.Dona.SozlukSitesi.service.serviceImpl;

import com.Dona.SozlukSitesi.dto.dtoComment.CommentCreateDto;
import com.Dona.SozlukSitesi.dto.dtoComment.CommentUpdateDto;
import com.Dona.SozlukSitesi.dto.dtoComment.CommentViewDto;
import com.Dona.SozlukSitesi.dto.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserViewDto;
import com.Dona.SozlukSitesi.exception.NotFoundException;
import com.Dona.SozlukSitesi.model.Comment;
import com.Dona.SozlukSitesi.model.Post;
import com.Dona.SozlukSitesi.model.User;
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

    @Override
    public CommentViewDto createComment(CommentCreateDto newComment) {
        UserViewDto userViewDto = userService.getUserById(newComment.getUserId());
        PostViewDto postViewDto = postService.getPostById(newComment.getPostId());
        if (userViewDto == null || postViewDto == null) {
            throw new NotFoundException("Not Found Exception");
        }

        User user = new User();
        user.setId(userViewDto.getId());
        Post post = new Post();
        post.setId(postViewDto.getId());

        Comment commentSave = new Comment();
        commentSave.setUser(user);
        commentSave.setPost(post);
        commentSave.setText(newComment.getText());

        Comment comment = commentRepository.save(commentSave);
        return CommentViewDto.of(comment);
    }

    @Override
    public CommentViewDto getCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        Comment comment = optionalComment.orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return CommentViewDto.of(comment);
    }

    @Override
    public void deleteComment(Long id) {
        final Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        commentRepository.deleteById(id);
    }

    @Override
    public CommentViewDto updateComment(Long id, CommentUpdateDto commentUpdateDto) {
        final Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        comment.setText(commentUpdateDto.getText());
        final Comment updateComment = commentRepository.save(comment);

        return CommentViewDto.of(updateComment);
    }


}
