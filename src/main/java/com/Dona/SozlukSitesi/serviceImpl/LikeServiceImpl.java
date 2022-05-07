package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dtoLike.LikeViewDto;
import com.Dona.SozlukSitesi.repository.LikeRepository;
import com.Dona.SozlukSitesi.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @Override
    public List<LikeViewDto> getAllLikes() {
        return likeRepository.findAll().stream().map(LikeViewDto::of).collect(Collectors.toList());
    }
}
