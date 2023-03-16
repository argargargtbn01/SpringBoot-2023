package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Modifying
    @Query("SELECT t " +
            "FROM Task t " +
            "WHERE t.user.id = :user_id ")
    List<Task> findByUserId( Long user_id);
}