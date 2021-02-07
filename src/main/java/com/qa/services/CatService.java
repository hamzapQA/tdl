package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.DestructionCallbackBindingListener;

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.dtos.CatDTO;
import com.qa.persistence.repos.CatRepo;
//this method is designed to use the cat controller 
@Service
public class CatService {

	private CatRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
		
	//POST (CREATE)
	public CatDTO create(CatDomain cat) {
		return this.mapToDTO(this.repo.save(cat));
	}
	
	//GET (READ)
	public List<CatDTO> readAll() {
		List<CatDomain> dbList = this.repo.findAll();
		List<CatDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}
	
}
