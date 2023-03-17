package com.example.demo.service;

import com.example.demo.dto.request.TaskRequestDto;
import com.example.demo.dto.response.TaskResponseDto;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponseDto> getTaskByUserId(Long user_id) {
        List<Task> tasks = taskRepository.findByUserId(user_id);
        List<TaskResponseDto> taskResponseDtos = new ArrayList<>();
        for (Task task : tasks) {
            taskResponseDtos.add(taskMapper.toTaskResponseDto(task));
        }
        return taskResponseDtos;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = taskMapper.toTask(taskRequestDto);
        User user = userRepository.findById(task.getUser().getId()).orElseThrow(() -> new NotFoundException("Khong tim thay user"));
        task.setUser(user);
        taskRepository.save(task);
        TaskResponseDto taskResponseDto = taskMapper.toTaskResponseDto(task);
        return taskResponseDto;
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()){
            Task task = taskMapper.toTask(taskRequestDto);
            task.setId(id);
            User user = userRepository.findById(task.getUser().getId()).orElseThrow(() -> new NotFoundException("Khong tim thay user"));
            task.setUser(user);
            task = taskRepository.save(task);
            TaskResponseDto taskResponseDto = taskMapper.toTaskResponseDto(task);
            return taskResponseDto;
        }
        throw  new NotFoundException("Khong tim thay task");
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()){
            taskRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("Khong tim thay task");
        }
    }
}
