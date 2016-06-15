package com.erkanerol.example.controller;

import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erkan on 12.06.2016.
 */
@RestController
public class TaskConroller {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/task" , method = RequestMethod.GET)
    List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    Task getTaskById(@PathVariable Long id){
        return taskRepository.findOne(id);
    }

    @RequestMapping(value = "/task/", method = RequestMethod.POST)
    Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @RequestMapping(value = "/task/", method = RequestMethod.PUT)
    Task updateTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    void deleteTask(@PathVariable("id") Long id){
        taskRepository.delete(id);
    }



}
