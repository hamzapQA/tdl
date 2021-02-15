package com.qa.persistence.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;



@Entity
public class MemberDomain {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId; 
	private String name;
	private boolean completed;

	
	@Size(min = 1, max = 140)
	private String notes;
	
	@ManyToOne
	private TDLDomain taskMembers;

	//constructor generated from superclass
	public MemberDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor generated using fields
	public MemberDomain(Long memberId, String name, boolean completed, @Size(min = 1, max = 140) String notes,
			TDLDomain taskMembers) {
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
