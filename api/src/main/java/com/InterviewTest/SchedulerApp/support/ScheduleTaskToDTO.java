package com.InterviewTest.SchedulerApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;
import com.InterviewTest.SchedulerApp.web.dto.ScheduleTaskDTO;

@Component
public class ScheduleTaskToDTO implements Converter<ScheduleTask, ScheduleTaskDTO> {

	@Override
	public ScheduleTaskDTO convert(ScheduleTask source) {
		ScheduleTaskDTO dto = new ScheduleTaskDTO();
		dto.setId(source.getId());
		dto.setName(source.getName());
		dto.setCode(source.getCode());
		dto.setRecurrency(source.getRecurrency());
		return dto;
	}
	
	public List<ScheduleTaskDTO> convert(List<ScheduleTask> tasks){
		List<ScheduleTaskDTO> dtos = new ArrayList<ScheduleTaskDTO>();
		for(ScheduleTask task : tasks) {
			ScheduleTaskDTO dto = convert(task);
			dtos.add(dto);
		}
		return dtos;
	}

}
