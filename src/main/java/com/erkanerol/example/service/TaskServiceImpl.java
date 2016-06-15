package com.erkanerol.example.service;

import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erkan on 15.06.2016.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    public Task getById(Long id){
        return taskRepository.findOne(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
