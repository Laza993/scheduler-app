package com.InterviewTest.SchedulerApp.service.impl;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.InterviewTest.SchedulerApp.config.ThreadPoolTaskSchedulerConfig;
import com.InterviewTest.SchedulerApp.model.ScheduleTask;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskExecutingService;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskService;
import com.InterviewTest.SchedulerApp.support.RunnableTask;
import com.InterviewTest.SchedulerApp.support.StringToTrigger;




@Service
public class JpaScheduleTaskExecutingService implements ScheduleTaskExecutingService{

	Logger logger = LoggerFactory.getLogger(ScheduleTaskExecutingService.class);
	
	@Autowired
	private ScheduleTaskService taskService;
	
	private static Map<Long, ScheduledFuture<?>> scheduledTasks =
	        new HashMap<Long, ScheduledFuture<?>>();
	
	@Autowired
    private ThreadPoolTaskSchedulerConfig taskScheduler;
	@Autowired
	private StringToTrigger toCron;


	@Async
	@Override
	public CompletableFuture<ScheduleTask> run(ScheduleTask task){
		try {
			RunnableTask runn = new RunnableTask(task);	
			CronTrigger trigger = toCron.run(task);
			
			ScheduledFuture<?> future = taskScheduler.threadPoolTaskScheduler().schedule(runn, trigger);
			
			scheduledTasks.put(task.getId(), future);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return CompletableFuture.completedFuture(task);
	}


	@Override
	public void stop(Long id) {
		scheduledTasks.get(id).cancel(true);

	}

}
