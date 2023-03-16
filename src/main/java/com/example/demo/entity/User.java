package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(nullable = false,length = 50)
    private String phone;
    @Column(nullable = false,length = 50)
    private String avatar;
    @Column(nullable = false,length = 50)
    private String password;
}
