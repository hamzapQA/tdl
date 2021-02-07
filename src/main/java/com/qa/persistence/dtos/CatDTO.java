package com.qa.persistence.dtos;
//DTO allows you to manipulate which objects you wish to return from the entity domain
//In this example, "age" is not returned as there are no getters and setters
public class CatDTO {
	private Long id;
	private String name;
	private int age;
	private float speechVolume;
	
	public CatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatDTO(Long id, String name, float speechVolume) {
		super();
		this.id = id;
		this.name = name;
		this.speechVolume = speechVolume;
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

	public float getSpeechVolume() {
		return speechVolume;
	}

	public void setSpeechVolume(float speechVolume) {
		this.speechVolume = speechVolume;
	}
	
	
	
}
