package com.example.Task.service;

import com.example.Task.entity.Task;
import com.example.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public void addTask(Task task) {
        this.taskRepository.save(task);
    }
    public void deleteEntityById(long id) {
        this.taskRepository.deleteById(id);
    }

    public Iterable<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task getById(long id) {
        Optional<Task> optional = taskRepository.findById(id);
        Task task = null;

        if(optional.isPresent()){
            task = optional.get();
        }else{
            throw  new RuntimeException("Task is not found for id ::" + id);
        }
        return task;
    }
}
