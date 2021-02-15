package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.TDLDomain;
import com.qa.persistence.dtos.TDLDTO;
import com.qa.persistence.repos.TDLRepo;

@Service
public class TDLService {

	private TDLRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public TDLService(TDLRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private TDLDTO mapToDTO(TDLDomain model) {
		return this.mapper.map(model, TDLDTO.class);
	}
	
	public TDLDTO create(TDLDomain model) {
		return this.mapToDTO(this.repo.save(model));
		
	}
	
	public List<TDLDTO> readAll(){
		
		List<TDLDomain> dbList = this.repo.findAll();
		
		List<TDLDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
		
	}
	
	public TDLDTO readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
		
	}

	
	public TDLDTO updateToDo(Long id, TDLDomain newDetails) {
		this.repo.findById(id).orElseThrow();
		newDetails.setId(id);
		return this.mapToDTO(this.repo.save(newDetails));
		
	}
	
	public boolean deleteToDo(long id) {
	this.repo.deleteById(id);
	return !this.repo.existsById(id);
	}
	
}
