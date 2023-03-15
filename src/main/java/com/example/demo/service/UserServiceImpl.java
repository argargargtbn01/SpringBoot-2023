package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public List<UserResponseDto> getListUser() {
        List<UserResponseDto> users = new ArrayList<>();
        List<User> res = userRepository.findAll();
        for (User user : res) {
            users.add(userMapper.toUserResponseDto(user));
        }
        return users;
    }

    public UserResponseDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
            return userResponseDto;
        }
        throw new NotFoundException("Ko tim duoc user");

    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        userRepository.save(user);
        UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userMapper.toUser(userRequestDto);
            userRepository.save(user);
            UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
            return userResponseDto;
        }
        throw new NotFoundException("Ko tim duoc user");
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("Ko tim duoc user");
        }
    }
}
