package com.example.demo.mapper;

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

    public Task toTask(TaskResponseDto taskResponseDto){
        Task task = new Task();
        task.setId(taskResponseDto.getId());
        task.setTitle(taskResponseDto.getTitle());
        task.setDescription(taskResponseDto.getDescription());
        task.setUser(taskResponseDto.getUser());
        task.setStatus(taskResponseDto.getStatus());
        return task;
    }
}
