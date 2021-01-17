package com.InterviewTest.SchedulerApp.service.impl;

import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.InterviewTest.SchedulerApp.service.TaskSchedullerService;

public class JpaTaskSchedullerService implements TaskSchedullerService {

	@Override
	public void executeTask(Runnable run, String cron) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
	}

	

}
