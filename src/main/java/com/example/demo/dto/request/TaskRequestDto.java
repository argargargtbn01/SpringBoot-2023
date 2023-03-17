package com.example.demo.dto.request;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    private Long id;
    private String title;
    private String description;
    private User user;
    private int status;
    private String created_at;
    private String updated_at;
}
