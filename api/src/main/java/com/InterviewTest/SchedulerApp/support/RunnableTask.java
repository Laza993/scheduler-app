package com.InterviewTest.SchedulerApp.support;

import java.util.Date;



import com.InterviewTest.SchedulerApp.model.ScheduleTask;

import groovy.lang.GroovyShell;


public class RunnableTask implements Runnable {
	GroovyShell shell = new GroovyShell();
	private ScheduleTask task;
	
	
	public RunnableTask(ScheduleTask task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		shell.evaluate(task.getCode());
		System.out.println("Task executed at "+ task.getName() + "  " + new Date() + " thread " + Thread.currentThread().getName());
	}
}
