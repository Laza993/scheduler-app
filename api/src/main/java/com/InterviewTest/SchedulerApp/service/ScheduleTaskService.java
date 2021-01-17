package com.InterviewTest.SchedulerApp.service;

import java.util.List;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;



public interface ScheduleTaskService {
	ScheduleTask getTask(Long id);
	List<ScheduleTask> getAllTasks();
	ScheduleTask save(ScheduleTask newTask);
	ScheduleTask delete(Long id);
	ScheduleTask update(ScheduleTask taskUpdate, Long id);
	
	
}
