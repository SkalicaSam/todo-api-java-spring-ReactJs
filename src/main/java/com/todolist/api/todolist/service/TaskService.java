package com.todolist.api.todolist.service;

import com.todolist.api.todolist.model.Task;
import com.todolist.api.todolist.model.User;
import com.todolist.api.todolist.repository.TaskRepository;
import com.todolist.api.todolist.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksByUserId(Integer userId) {
        return taskRepository.findAllByUserId(userId);

    }


    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Integer userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        task.setUser(user);
        task.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return taskRepository.save(task);
    }


    public Task updateTask(Integer id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        task.setName(taskDetails.getName());
        task.setStatus(taskDetails.getStatus());
        task.setCategory(taskDetails.getCategory());
        task.setDescription(taskDetails.getDescription());
        task.setCreatedAt(taskDetails.getCreatedAt());
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
