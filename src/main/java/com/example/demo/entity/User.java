package com.example.demo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String avatar;
    @Column
    private String password;
}
