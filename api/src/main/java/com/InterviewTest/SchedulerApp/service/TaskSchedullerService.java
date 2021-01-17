package com.InterviewTest.SchedulerApp.service;

import org.springframework.scheduling.annotation.SchedulingConfigurer;

public interface TaskSchedullerService extends SchedulingConfigurer {
	void executeTask(Runnable run, String cron);
}
