package com.erkanerol.example.dao;

import com.erkanerol.example.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erkan on 29.05.2016.
 */
@Repository
public class TaskDao {

    public List<Task> getAllTasks(){
        List<Task> tasks = new ArrayList<Task>();

        Task task = new Task();
        task.setId(1l);
        task.setTitle("Rest Api Title");
        task.setDetails("Rest Api Crate");
        task.setDone(false);

        tasks.add(task);

        return tasks;

    }
}
