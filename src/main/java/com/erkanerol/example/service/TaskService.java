package com.erkanerol.example.service;

import com.erkanerol.example.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erkan on 15.06.2016.
 */
public interface TaskService {
    public Task getById(Long id);
    public List<Task> getAllTasks();
}
