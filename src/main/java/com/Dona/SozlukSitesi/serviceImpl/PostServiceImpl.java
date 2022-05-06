package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dtoPost.PostViewDto;
import com.Dona.SozlukSitesi.repository.PostRepository;
import com.Dona.SozlukSitesi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostViewDto> getAllPosts() {
        return postRepository.findAll().stream().map(PostViewDto::of).collect(Collectors.toList());
    }
}
