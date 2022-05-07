package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dtoLike.LikeCreateDto;
import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;
import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.dtoUser.UserViewDto;
import com.Dona.SozlukSitesi.exception.NotFoundException;
import com.Dona.SozlukSitesi.model.Like;
import com.Dona.SozlukSitesi.model.Post;
import com.Dona.SozlukSitesi.model.User;
import com.Dona.SozlukSitesi.repository.LikeRepository;
import com.Dona.SozlukSitesi.service.LikeService;
import com.Dona.SozlukSitesi.service.PostService;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeServiceImpl(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<LikeViewDto> getAllLikes(Optional<Long> postId, Optional<Long> userId) {
        List<Like> list;
        if (postId.isPresent()) {//http://localhost:8088/likes?postId=2  kullanimi
            list = likeRepository.findByPostId(postId.get());//bu postta atilan likeları getirir
        } else if (userId.isPresent()) {//http://localhost:8088/likes?userId=2  kullanimi
            list = likeRepository.findByUserId(userId.get());//bu userin attigi likeları getirir
        } else {
            list = likeRepository.findAll();
        }
        return list.stream().map(LikeViewDto::of).collect(Collectors.toList());
    }

    @Override
    public LikeViewDto createLike(LikeCreateDto likeCreateDto) {
        UserViewDto userViewDto = userService.getUserById(likeCreateDto.getUserId());
        PostViewDto postViewDto = postService.getPostById(likeCreateDto.getPostId());
        if (userViewDto == null || postViewDto == null) {
            throw new NotFoundException("Not Found Exception");
        }

        User user = new User();
        user.setId(userViewDto.getId());
        Post post = new Post();
        post.setId(postViewDto.getId());

        Like likeSave = new Like();
        likeSave.setUser(user);
        likeSave.setPost(post);

        Like like = likeRepository.save(likeSave);
        return LikeViewDto.of(like);
    }

    @Override
    public LikeViewDto getLikeById(Long likeId) {
        Optional<Like> optionalLike = likeRepository.findById(likeId);
        Like like = optionalLike.orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return LikeViewDto.of(like);
    }

    @Override
    public void deleteLike(Long likeId) {
        final Like like = likeRepository.findById(likeId).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        likeRepository.deleteById(likeId);
    }
}
