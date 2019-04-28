package com.cts.taskmanagerrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.taskmanagerrest.model.Task;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task, Integer> {
    @Transactional
    @Modifying
    @Query("update Task task set task.editEnabled = :editEnabled,task.endDate=sysdate() where task.taskId = :taskId")
    void softDelete(@Param("editEnabled") String editEnabled,@Param("taskId") Integer taskId);
}
