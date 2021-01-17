package com.InterviewTest.SchedulerApp.service.impl;


import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InterviewTest.SchedulerApp.model.ScheduleTask;
import com.InterviewTest.SchedulerApp.repository.ScheduleTaskRepository;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskService;



@Service
public class JpaScheduleTaskServiceImpl implements ScheduleTaskService {
	
	@Autowired
	private ScheduleTaskRepository taskRepository;
//	@Autowired
//	private ScheduleTaskExecutingService executeTask;

	@Override
	public ScheduleTask getTask(Long id) {
		Optional<ScheduleTask> obj = null;
		ScheduleTask task = null;
		try {
			obj = taskRepository.findById(id);
			if(obj.isEmpty()) {
				return null;
			}else {
				task = obj.get();
			}
		} catch (Exception  e) {
			System.out.println("not found");
		}

		return task;
	}

	@Override
	public List<ScheduleTask> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public ScheduleTask save(ScheduleTask newTask) {
		ScheduleTask saved = taskRepository.save(newTask);
		return saved;
	}

	@Override
	public ScheduleTask delete(Long id) {
		ScheduleTask toDelete = getTask(id);
		if(toDelete != null) {
			taskRepository.delete(toDelete);
		}
		return toDelete;
	}

	@Override
	public ScheduleTask update(ScheduleTask taskUpdate, Long id) {
		taskUpdate.setId(id);
		return taskRepository.save(taskUpdate);
	}
			
	@PostConstruct
	public void init() {
		String name1 = "task1";
		String recurrency = "*/5 * * * * ?";
		String code = "for(1..10){println \"Hello World\" sleep(1000)}";
		
		ScheduleTask taskOne = new ScheduleTask(name1, recurrency, code);
		save(taskOne);
//		executeTask.run(taskOne);
	}

}
