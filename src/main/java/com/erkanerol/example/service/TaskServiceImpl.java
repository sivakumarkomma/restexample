package com.erkanerol.example.service;

import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.exceptions.NoContentException;
import com.erkanerol.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erkan on 15.06.2016.
 */
@Service
public class TaskServiceImpl implements  TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task getById(Long id) throws NoContentException {
        Task task =  taskRepository.findOne(id);
        if(task == null){
            throw new NoContentException();
        }else{
            return task;
        }
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task create(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public Task update(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(id);
    }
}
