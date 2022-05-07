package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dtoPost.PostCreateDto;
import com.Dona.SozlukSitesi.dtoPost.PostUpdateDto;
import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.dtoUser.UserViewDto;
import com.Dona.SozlukSitesi.exception.NotFoundException;
import com.Dona.SozlukSitesi.model.Post;
import com.Dona.SozlukSitesi.model.User;
import com.Dona.SozlukSitesi.repository.PostRepository;
import com.Dona.SozlukSitesi.service.PostService;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<PostViewDto> getAllPosts() {
        return postRepository.findAll().stream().map(PostViewDto::of).collect(Collectors.toList());
    }

    @Override
    public PostViewDto createPost(PostCreateDto newPost) {
        UserViewDto userViewDto = userService.getUserById(newPost.getUserId());
        if (userViewDto == null) {
            throw new NotFoundException("Not Found Exception");
        }
        User user = new User();
        user.setId(userViewDto.getId());
        user.setUserName(userViewDto.getUserName());

        Post postSave = new Post();
        postSave.setText(newPost.getText());
        postSave.setTitle(newPost.getTitle());
        postSave.setUser(user);
        Post post = postRepository.save(postSave);

        return PostViewDto.of(post);
    }

    @Override
    public PostViewDto getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        Post post = optionalPost.orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return PostViewDto.of(post);
    }

    @Override
    public void deletePost(Long id) {
        final Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        postRepository.deleteById(id);
    }

    @Override
    public PostViewDto updatePost(Long id, PostUpdateDto postUpdateDto) {
        final Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        post.setTitle(postUpdateDto.getTitle());
        post.setText(postUpdateDto.getText());
        final Post updatePost = postRepository.save(post);

        return PostViewDto.of(updatePost);
    }
}
