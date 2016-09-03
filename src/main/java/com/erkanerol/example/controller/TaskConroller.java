package com.erkanerol.example.controller;

import com.erkanerol.example.exceptions.RestException;
import com.erkanerol.example.model.Task;
import com.erkanerol.example.exceptions.NoContentException;
import com.erkanerol.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erkan on 12.06.2016.
 */
@RestController
public class TaskConroller {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/task" , method = RequestMethod.GET)
    List<Task> getAllTasks(){
        return taskService.getAll();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    ResponseEntity<Task> getTaskById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(taskService.getById(id));
        } catch (NoContentException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @RequestMapping(value = "/task/", method = RequestMethod.POST)
    Task createTask(@RequestBody Task task){
        System.out.println(task);
        return taskService.create(task);
    }

    @RequestMapping(value = "/task/", method = RequestMethod.PUT)
    Task updateTask(@RequestBody Task task){
        return taskService.update(task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    void deleteTask(@PathVariable("id") Long id){
        taskService.delete(id);
    }



}
