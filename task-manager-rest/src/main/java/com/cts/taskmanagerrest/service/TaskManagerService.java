package com.cts.taskmanagerrest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.taskmanagerrest.model.Task;
import com.cts.taskmanagerrest.repository.TaskManagerRepository;

@Service
public class TaskManagerService {
	public static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerService.class);

	@Autowired
	TaskManagerRepository taskManagerRepository;

	@Transactional
	public void createTask(Task task) throws DataAccessException {
		LOGGER.info("Saving Task To Database-->" + task);
		task = taskManagerRepository.save(task);

	}

	public List<?> getTasks() throws DataAccessException {
		LOGGER.info("Retrieving Tasks From Database-->");
		return taskManagerRepository.findAll();

	}

	public Optional<Task> getTaskById(Integer id) throws DataAccessException{
		LOGGER.info("Retrieving Task "+id+" from Database");
		return taskManagerRepository.findById(id);
	}

	public void updateTask(Task task) throws DataAccessException{
		LOGGER.info("Updating Task "+task.getTaskId());
		taskManagerRepository.save(task);

	}

	@Transactional
	public void deleteTask(Task task) throws DataAccessException{
		LOGGER.info("Deleting Task "+task);
		taskManagerRepository.delete(task);
	}

	@Transactional
	public void softDeleteAndUpdateTask(Task task) throws DataAccessException{
		LOGGER.info("Soft Deleting Task "+task);
		taskManagerRepository.softDelete(task.getEditEnabled(),task.getTaskId());
	}

}
