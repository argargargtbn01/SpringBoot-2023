package com.example.demo.mapper;

import com.example.demo.dto.request.TaskRequestDto;
import com.example.demo.dto.response.TaskResponseDto;
import com.example.demo.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskResponseDto toTaskResponseDto (Task task){
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setUser(task.getUser());
        taskResponseDto.setStatus(task.getStatus());
        return taskResponseDto;
    }

    public Task toTask(TaskRequestDto taskRequestDto){
        Task task = new Task();
        task.setId(taskRequestDto.getId());
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setUser(taskRequestDto.getUser());
        task.setStatus(taskRequestDto.getStatus());
        return task;
    }
}
