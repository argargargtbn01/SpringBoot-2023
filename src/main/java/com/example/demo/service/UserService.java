package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String keyword);
}
