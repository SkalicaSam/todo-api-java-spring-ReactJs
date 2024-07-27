package com.todolist.api.todolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import lombok.Data;

//import java.sql.Timestamp;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
    private String name;
    private Integer status;
    private String category;
    private String description;
    private Timestamp createdAt;


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NonNull Integer status) {
        this.status = status;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }




    //
//    public Task() {
//    }
//
//    public Task(@Nullable Integer id, @NonNull Integer userId, @NonNull String name, @NonNull Integer status, @NonNull String category, @NonNull String description, @NonNull Timestamp createdAt) {
//        Id = id;
//        this.userId = userId;
//        this.name = name;
//        this.status = status;
//        this.category = category;
//        this.description = description;
//        this.createdAt = Timestamp.from(Instant.now());
//    }
//
//    @Nullable
//    public Integer getId() {
//        return Id;
//    }
//
//    public void setId(@Nullable Integer id) {
//        Id = id;
//    }
//
//    @NonNull
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(@NonNull Integer userId) {
//        this.userId = userId;
//    }
//
//    @NonNull
//    public String getName() {
//        return name;
//    }
//
//    public void setName(@NonNull String name) {
//        this.name = name;
//    }
//
//    @NonNull
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(@NonNull Integer status) {
//        this.status = status;
//    }
//
//    @NonNull
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(@NonNull String category) {
//        this.category = category;
//    }
//
//    @NonNull
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(@NonNull String description) {
//        this.description = description;
//    }
//
//    @NonNull
//    public Timestamp getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(@NonNull Timestamp createdAt) {
//        this.createdAt = createdAt;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "Id=" + Id +
//                ", userId=" + userId +
//                ", name='" + name + '\'' +
//                ", status=" + status +
//                ", category='" + category + '\'' +
//                ", description='" + description + '\'' +
//                ", createdAt=" + createdAt +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task = (Task) o;
//        return Objects.equals(Id, task.Id) && Objects.equals(userId, task.userId) && Objects.equals(name, task.name) && Objects.equals(status, task.status) && Objects.equals(category, task.category) && Objects.equals(description, task.description) && Objects.equals(createdAt, task.createdAt);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(Id, userId, name, status, category, description, createdAt);
//    }
}
