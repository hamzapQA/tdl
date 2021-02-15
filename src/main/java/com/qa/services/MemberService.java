package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.MemberDomain;
import com.qa.persistence.dtos.MemberDTO;
import com.qa.persistence.repos.MemberRepo;

@Service
public class MemberService {
	
	private MemberRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public MemberService(MemberRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		
	}
	
	private MemberDTO mapToDTO(MemberDomain model) {
		return this.mapper.map(model, MemberDTO.class);
	}
	
	
	//create
	public MemberDTO create(MemberDomain model) {
		return this.mapToDTO(this.repo.save(model));
		
	}
	
	//read all tasks
	public List<MemberDTO> readAll(){
		List<MemberDomain> dbList = this.repo.findAll();
		List<MemberDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}
	
	//read by ID
	
	public MemberDTO readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	//update
	
	public MemberDTO updateTask(Long id, MemberDomain newDetails) {
		this.repo.findById(id).orElseThrow();
		newDetails.setMemberId(id);
		return this.mapToDTO(this.repo.save(newDetails));
	}
	
	//delete
	
	public boolean deleteTask(long id) {
		this.repo.deleteById(id);
		boolean flag = !this.repo.existsById(id);
		return flag;
	}
	

}
