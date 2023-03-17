package com.example.demo.service;

import com.example.demo.dto.request.TaskRequestDto;
import com.example.demo.dto.response.TaskResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskResponseDto> getTaskByUserId (Long user_id);

    TaskResponseDto createTask(TaskRequestDto taskRequestDto);

    TaskResponseDto updateTask(Long id,TaskRequestDto taskRequestDto);

    void deleteTask(Long id);
}
