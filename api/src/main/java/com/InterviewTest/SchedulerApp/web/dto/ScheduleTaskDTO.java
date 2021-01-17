package com.InterviewTest.SchedulerApp.web.dto;

import javax.validation.constraints.NotBlank;

public class ScheduleTaskDTO {
	
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String recurrency;
	@NotBlank
	private String code;
	
	
	
	
	public ScheduleTaskDTO(String name, String recurrency, String code) {
		super();
		this.name = name;
		this.recurrency = recurrency;
		this.code = code;
	}
	public ScheduleTaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecurrency() {
		return recurrency;
	}
	public void setRecurrency(String recurrency) {
		this.recurrency = recurrency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
