package com.Dona.SozlukSitesi.serviceImpl;

import com.Dona.SozlukSitesi.dto.UserViewDto;
import com.Dona.SozlukSitesi.repository.UserRepository;
import com.Dona.SozlukSitesi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
