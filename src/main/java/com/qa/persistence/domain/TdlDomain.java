package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//alt shift r allows you to refactor efficiently
public class TdlDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   ///id is FK in SQL structure, this tells Spring the id is auto-gen
	private Long id;
	private String task;
	private int priority;
	private float effortLevel;
	
	//alt + shift + s
	//CONSTRUCTOR
	//No Args - "Generate Constructor from Superclass"
	
	public TdlDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
//
	//All Args - "Generate Constructor Using Fields"
	//METHODS
	
	public TdlDomain(Long id, String task, int priority, float effortLevel) {
		super();
		this.id = id;
		this.task = task;
		this.priority = priority;
		this.effortLevel = effortLevel;
	}


	//Auto-Generated Getters and Setters - "Generate Getters and Setters"
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int age) {
		this.priority = age;
	}

	public float getEffortLevel() {
		return effortLevel;
	}

	public void setEffortLevel(float effortLevel) {
		this.effortLevel = effortLevel;
	}
	

	
}
