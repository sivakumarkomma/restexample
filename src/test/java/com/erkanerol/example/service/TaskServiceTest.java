package com.erkanerol.example.service;


import com.erkanerol.example.RestExampleApplication;
import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.exceptions.NoContentException;
import com.erkanerol.example.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestExampleApplication.class)
@WebAppConfiguration
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
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
        taskList = taskRepository.save(taskList);

    }

    @Test
    public void getAllTasks_NotEmptyList_ReturnList() throws Exception {
        List<Task> allTasks = taskService.getAll();
        assertTrue(allTasks.size() == taskList.size());
    }

    @Test
    public void getTaskById_ExistingTask_ReturnTask() throws Exception {
        Long taskIdInList = taskList.get(0).getId();
        Task task = taskService.getById(taskIdInList);
        assertTrue(task.getId().equals(taskIdInList));
    }

    @Test(expected = NoContentException.class)
    public  void getTaskById_NotExistingTask_ThrowsNoContentException() throws NoContentException{
        Task task = taskService.getById(-1l);
    }

    @Test
    public void createTask_ValidTask_ReturnTask(){
        Task task  = new Task("createTask","createTaskDetail",false);
        Task createdTask = taskService.create(task);
        assertTrue(createdTask.getId() != null);
    }

    @Test
    public void createTask_NonValidWithId_ThrowsException(){
        Task task  = new Task("createTask","createTaskDetail",false);
        task.setId(1l);
        Task createdTask = taskService.create(task);
        System.out.println("id:"+createdTask.getId());
        assertTrue(createdTask.getId() != null);
    }


}
