package com.InterviewTest.SchedulerApp.support;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;

@Component
public class StringToTrigger {
	
	public CronTrigger run(ScheduleTask task) {
		return new CronTrigger(task.getRecurrency());
	}
}
