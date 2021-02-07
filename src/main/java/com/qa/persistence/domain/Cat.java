package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   ///id is FK in SQL structure, this tells Spring the id is auto-gen
	private Long id;
	private String name;
	private int age;
	private boolean speechVolume;
	
	//alt + shift + s
	//CONSTRUCTOR
	//No Args - "Generate Constructor from Superclass"
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//All Args - "Generate Constructor Using Fields"
	//METHODS
	
	public Cat(Long id, String name, int age, boolean speechVolume) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}

	//Auto-Generated Getters and Setters - "Generate Getters and Setters"
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isSpeechVolume() {
		return speechVolume;
	}


	public void setSpeechVolume(boolean speechVolume) {
		this.speechVolume = speechVolume;
	}	

}
