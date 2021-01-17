package com.InterviewTest.SchedulerApp.service;

import java.util.concurrent.CompletableFuture;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;

public interface ScheduleTaskExecutingService {
	CompletableFuture<ScheduleTask> run(ScheduleTask task);

	void stop(Long id);
	
	
}
