package com.cts.taskmanagerrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.taskmanagerrest.model.Task;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task, Integer> {

}
