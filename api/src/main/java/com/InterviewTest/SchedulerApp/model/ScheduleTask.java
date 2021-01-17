package com.InterviewTest.SchedulerApp.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "scheduleTask")
public class ScheduleTask {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "names", length = 250, nullable = false)
	private String name;
	@Column(name = "recurrency", length = 30, nullable = false)
	private String recurrency;
	@Column(name = "code", nullable = false)
	private String code;
	@Column(name = "startedDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startedDateTime;
	@Column(name = "createdDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;
	
	
	
	
	
	
	public ScheduleTask(String name, String recurrency, String code) {
		super();
		this.name = name;
		this.recurrency = recurrency;
		this.code = code;
		this.createdDateTime = new Date(System.currentTimeMillis());
	}
	public ScheduleTask() {
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
	public Date getStartedDateTime() {
		return startedDateTime;
	}
	public void setStartedDateTime(Date startedDateTime) {
		this.startedDateTime = startedDateTime;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	

}
