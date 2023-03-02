package com.example.demo.controller;

import com.example.demo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public ResponseEntity<?> dcm(){
        User user = new User(1,"quang");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
