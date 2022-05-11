package com.Dona.SozlukSitesi.service.serviceImpl;

import com.Dona.SozlukSitesi.dto.dtoUser.UserCreateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserUpdateViewDto;
import com.Dona.SozlukSitesi.dto.dtoUser.UserViewDto;
import com.Dona.SozlukSitesi.exception.NotFoundException;
import com.Dona.SozlukSitesi.model.User;
import com.Dona.SozlukSitesi.repository.LikeRepository;
import com.Dona.SozlukSitesi.repository.PostRepository;
import com.Dona.SozlukSitesi.repository.UserRepository;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository, LikeRepository likeRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
    }

    @Override
    public List<UserViewDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDto createUser(UserCreateDto newUser) {
        final User user = userRepository.save(new User(newUser.getUserName(), newUser.getPassword()));
        return UserViewDto.of(user);
    }

    @Override
    public UserViewDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDto.of(user);
    }

    @Override
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        userRepository.deleteById(id);
    }

    @Override
    public UserUpdateViewDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

        user.setUserName(userUpdateDto.getUserName());
        user.setPassword(userUpdateDto.getPassword());

        final User updateUser = userRepository.save(user);
        return UserUpdateViewDto.of(updateUser);

    }

    @Override
    public List<Object> getUserLikesActivity(Long userId) {
        List<Long> postIds = postRepository.findTopByUserId(userId);
        if (postIds.isEmpty()) {
            throw new NotFoundException("Not Found Exception");
        }
        List<Object> likes = likeRepository.findUserLikesByPostId(postIds);

        return likes;
    }
}
