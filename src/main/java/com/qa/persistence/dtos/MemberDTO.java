package com.qa.persistence.dtos;

import com.qa.persistence.domain.TDLDomain;

public class MemberDTO {


	private Long memberId; 
	private String name;
	private boolean completed;
	private String notes;
	

	private TDLDomain taskMembers;

//constructor generated from superclass
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


//constructor generated from fields
	public MemberDTO(Long memberId, String name, boolean completed, String notes, TDLDomain taskMembers) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.completed = completed;
		this.notes = notes;
		this.taskMembers = taskMembers;
	}

//getters and setters
	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public TDLDomain getTaskMembers() {
		return taskMembers;
	}


	public void setTaskMembers(TDLDomain taskMembers) {
		this.taskMembers = taskMembers;
	}

	



}
