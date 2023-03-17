package com.example.demo.controller;

import com.example.demo.dto.request.TaskRequestDto;
import com.example.demo.dto.response.TaskResponseDto;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/{user_id}")
    public ResponseEntity<List> getTaskByUserId(@PathVariable Long user_id){
        List<TaskResponseDto> taskResponseDtos = taskService.getTaskByUserId(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDtos);
    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto taskResponseDto = taskService.createTask(taskRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id,@RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto taskResponseDto = taskService.updateTask(id,taskRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
