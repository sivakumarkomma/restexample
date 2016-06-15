package com.erkanerol.example.service;


import com.erkanerol.example.RestExampleApplication;
import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestExampleApplication.class)
@WebAppConfiguration
public class TaskServiceTest {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    List<Task> taskList;
    Task homeWork;
    Task reading;
    Task cleaning;

    @Before
    public void setup() throws Exception {
        homeWork = new Task("HomeWork","Math 101",false);
        reading = new Task("Reading","Clean Code",true);
        cleaning = new Task("Cleaning","Bathroom",false);

        taskRepository.deleteAll();
        taskList = Arrays.asList(homeWork,reading,cleaning);
        taskRepository.save(taskList);

    }

    @Test
    public void getAllTasks_NotEmptyList_ReturnList() throws Exception {
        List<Task> allTasks = taskService.getAllTasks();
        assertTrue(allTasks.size() == taskList.size());
    }


}
