package com.example.demo.controller;

import com.example.demo.dto.response.TaskResponseDto;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
