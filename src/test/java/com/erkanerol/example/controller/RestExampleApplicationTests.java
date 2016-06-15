package com.erkanerol.example.controller;

import com.erkanerol.example.RestExampleApplication;
import com.erkanerol.example.dao.TaskRepository;
import com.erkanerol.example.model.Task;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestExampleApplication.class)
@WebAppConfiguration
public class RestExampleApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));


	@Autowired
	private TaskRepository taskRepository	;

	List<Task> taskList;
	Task homeWork;
	Task reading;
	Task cleaning;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		homeWork = new Task("HomeWork","Math 101",false);
		reading = new Task("Reading","Clean Code",true);
		cleaning = new Task("Cleaning","Bathroom",false);

		taskRepository.deleteAll();
		taskList = Arrays.asList(homeWork,reading,cleaning);
		taskRepository.save(taskList);

	}

	@Test
	public void getAllTasks_NotEmptyList_ReturnList() throws Exception {
		mockMvc.perform(get("/task"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(taskList.size())));
	}


	@Test
	public void getTaskById_Exists_ReturnObject() throws Exception {
		mockMvc.perform(get("/task/"+(taskList.get(0).getId())))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.id",is(taskList.get(0).getId().intValue())))
				.andExpect(jsonPath("$.title",is(taskList.get(0).getTitle())));
	}


	@Test
	public void getTaskById_NotExists_NoContent() throws Exception {
		mockMvc.perform(get("/task/-1"))
				.andExpect(status().isNoContent());
	}

}
