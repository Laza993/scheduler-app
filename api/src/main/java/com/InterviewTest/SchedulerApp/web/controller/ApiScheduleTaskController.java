package com.InterviewTest.SchedulerApp.web.controller;


import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.InterviewTest.SchedulerApp.model.ScheduleTask;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskExecutingService;
import com.InterviewTest.SchedulerApp.service.ScheduleTaskService;
import com.InterviewTest.SchedulerApp.support.DTOtoScheduleTask;
import com.InterviewTest.SchedulerApp.support.ScheduleTaskToDTO;
import com.InterviewTest.SchedulerApp.web.dto.ScheduleTaskDTO;

@RestController
@RequestMapping(value="api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiScheduleTaskController {
	
	@Autowired
	ScheduleTaskService taskService;
	@Autowired
	ScheduleTaskToDTO taskToDTOConverter;
	@Autowired
	DTOtoScheduleTask dtoToTaskConverter;
	@Autowired
	ScheduleTaskExecutingService executeTask;

	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
	public ResponseEntity<ScheduleTaskDTO> getTask(@PathVariable Long id) {
		ScheduleTask task = taskService.getTask(id);
		if(task == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(taskToDTOConverter.convert(task), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity<List<ScheduleTaskDTO>> getAll(){
		
		List<ScheduleTask> tasks = taskService.getAllTasks();
		if(tasks == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(taskToDTOConverter.convert(tasks), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/", produces = "application/json")
	public ResponseEntity<ScheduleTaskDTO> addTask(@RequestBody ScheduleTaskDTO dto) throws InterruptedException, ExecutionException{
		ScheduleTask saved = null;
		if(dto != null) {
			dto.setId(null);
			saved = taskService.save(dtoToTaskConverter.convert(dto));

			executeTask.run(saved);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(taskToDTOConverter.convert(saved), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = "application/json")
	public ResponseEntity<ScheduleTaskDTO> updateTask(@RequestBody ScheduleTaskDTO dto,	
														@PathVariable Long id){
		ScheduleTask saved = null;
		
		if(dto == null || !dto.getId().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(taskService.getTask(id) == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		saved = taskService.save(dtoToTaskConverter.convert(dto));
		return new ResponseEntity<>(taskToDTOConverter.convert(saved), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = "application/json")
	public ResponseEntity<ScheduleTaskDTO> deleteTask(@PathVariable Long id) {
		
		executeTask.stop(id);
		
		ScheduleTask deleted = taskService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(taskToDTOConverter.convert(deleted), HttpStatus.OK);
	}

}
