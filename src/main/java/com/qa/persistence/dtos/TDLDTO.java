package com.qa.persistence.dtos;

import java.util.List;

public class TDLDTO {
	
	private Long id;
	
	private String name;
	
	private List<MemberDTO> taskList;
	

	public TDLDTO() {
		super();
		
	}



	public TDLDTO(Long id, String name, List<MemberDTO> taskList) {
		super();
		this.id = id;
		this.name = name;
		this.taskList = taskList;
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



	public List<MemberDTO> getTaskList() {
		return taskList;
	}



	public void setTaskList(List<MemberDTO> taskList) {
		this.taskList = taskList;
	}



	

}
