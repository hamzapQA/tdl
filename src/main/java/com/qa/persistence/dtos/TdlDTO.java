package com.qa.persistence.dtos;
//DTO allows you to manipulate which objects you wish to return from the entity domain
//In this example, "age" is not returned as there are no getters and setters
public class TdlDTO {
	private Long id;
	private String task;
	private int priority;
	private float effortLevel;
	
	public TdlDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TdlDTO(Long id, String task, float effortLevel) {
		super();
		this.id = id;
		this.task = task;
		this.effortLevel = effortLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public float getEffortLevel() {
		return effortLevel;
	}

	public void setEffortLevel(float effortLevel) {
		this.effortLevel = effortLevel;
	}
	
	
	
}
