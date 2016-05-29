package com.erkanerol.example.rest;

import com.erkanerol.example.dao.TaskDao;
import com.erkanerol.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by erkan on 29.05.2016.
 */

@RestController
public class TodoRestController {

    @Autowired
    private TaskDao taskDao;

    @RequestMapping(value = "/task")
    public List<Task> getAllTasks(){
        return taskDao.getAll();
    }
}
