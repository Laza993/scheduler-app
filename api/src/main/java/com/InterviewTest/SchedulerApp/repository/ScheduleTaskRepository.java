package com.InterviewTest.SchedulerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;

@Repository
public interface ScheduleTaskRepository extends JpaRepository<ScheduleTask, Long> {

}
