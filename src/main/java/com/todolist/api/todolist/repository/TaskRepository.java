package com.todolist.api.todolist.repository;


import com.todolist.api.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByUserId(Integer userId);
}
