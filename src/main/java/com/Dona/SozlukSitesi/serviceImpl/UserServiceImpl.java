package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dto.UserCreateDto;
import com.Dona.SozlukSitesi.dto.UserViewDto;
import com.Dona.SozlukSitesi.exception.NotFoundException;
import com.Dona.SozlukSitesi.model.User;
import com.Dona.SozlukSitesi.repository.UserRepository;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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


}
