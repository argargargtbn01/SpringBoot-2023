package com.example.demo.service;

import com.example.demo.dto.request.TaskRequestDto;
import com.example.demo.dto.response.TaskResponseDto;
import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public List<TaskResponseDto> getTaskByUserId(Long user_id) {
        List<Task> tasks = taskRepository.findByUserId(user_id);
        List<TaskResponseDto> taskResponseDtos= new ArrayList<>();
        for (Task task : tasks){
            taskResponseDtos.add(taskMapper.toTaskResponseDto(task));
        }
        return taskResponseDtos;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}
