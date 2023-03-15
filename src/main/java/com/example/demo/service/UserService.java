package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<UserResponseDto> getListUser();

     UserResponseDto getUserById(Long id);

     UserResponseDto createUser (UserRequestDto userRequestDto);

     UserResponseDto updateUser (Long id,UserRequestDto userRequestDto);

     void deleteUser (Long id);


}
