package com.InterviewTest.SchedulerApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@ComponentScan
@Configuration
public class ThreadPoolTaskSchedulerConfig {

	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		taskScheduler.setThreadNamePrefix("threadPoolTaskScheduler");
		taskScheduler.initialize();
		return taskScheduler;
	}
}
