package com.cts.taskmanagerrest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cts.taskmanagerrest.model.Task;
import com.cts.taskmanagerrest.model.Test;
import com.cts.taskmanagerrest.service.TaskManagerService;

@RestController
@RequestMapping(path = "/api/taskmanager")
public class TaskManagerController {
	public static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerController.class);

	@Autowired
	TaskManagerService taskManagerService;

	@GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {
		LOGGER.info("from inside ping method");
		return "Ping Service";
	}

	@PostMapping(path = "/createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createTask(@RequestBody Task task) {
		LOGGER.info("Entry For Creating Task--> " + task);
		taskManagerService.createTask(task);
	}

	@GetMapping(path = "/getTasks")
	public List<?> getTasks() {
		LOGGER.info("Entry For Retrieving Tasks--> ");
		List<?> tasks= taskManagerService.getTasks();
		LOGGER.info("Tasks--> "+tasks);
		return tasks;
	}

	@GetMapping(path="/getTask/{id}")
	public Task getTaskById(@PathVariable("id") Integer id) {
		Optional<Task> task=taskManagerService.getTaskById(id);
		return task.get();
	}

	@PutMapping(path="/updateTask")
	public void updataTask(@RequestBody Task task){
		LOGGER.info("Update--> "+task);
		taskManagerService.updateTask(task);

	}
	@DeleteMapping(path="deleteTask")
	public void deleteTask(@RequestBody Task task){
		LOGGER.info("Delete Task--> "+task);
		taskManagerService.deleteTask(task);
	}

	//Testing purpose
	//http://localhost:8085/api/taskmanager/getTaskVal?val1=prasenjit&val2=das
	@GetMapping(path = "/getTaskVal")
	public void getTaskVal(@RequestParam Map<String,String> map) {
		LOGGER.info("Entry For Retrieving Tasks--> "+map);
		
		
		//return test;
	}

}
