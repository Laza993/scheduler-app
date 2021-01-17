package com.InterviewTest.SchedulerApp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskService;
import com.InterviewTest.SchedulerApp.web.dto.ScheduleTaskDTO;

@Component
public class DTOtoScheduleTask implements Converter<ScheduleTaskDTO, ScheduleTask> {
	@Autowired
	ScheduleTaskService taskService;
	
	@Override
	public ScheduleTask convert(ScheduleTaskDTO source) {
		if(source.getId() == null) {
			return new ScheduleTask(source.getName(), source.getRecurrency(), source.getCode());
		}else {
			ScheduleTask task = taskService.getTask(source.getId());
			task.setName(source.getName());
			task.setCode(source.getCode());
			task.setRecurrency(source.getRecurrency());
			return task;
		}
		
	}
	
}
