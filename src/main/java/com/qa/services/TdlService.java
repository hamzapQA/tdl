package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.DestructionCallbackBindingListener;

import com.qa.persistence.domain.TdlDomain;
import com.qa.persistence.dtos.TdlDTO;
import com.qa.persistence.repos.TdlRepo;
//this method is designed to use the cat controller 
@Service
public class TdlService {

	private TdlRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public TdlService(TdlRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private TdlDTO mapToDTO(TdlDomain model) {
		return this.mapper.map(model, TdlDTO.class);
	}
		
	//POST (CREATE)
	public TdlDTO create(TdlDomain item) {
		return this.mapToDTO(this.repo.save(item));
	}
	
	//GET (READ)
	public List<TdlDTO> readAll() {
		List<TdlDomain> dbList = this.repo.findAll();
		List<TdlDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}
	
	//GET (READ specific)
	public TdlDTO readOne(Long id) {
	return mapToDTO(this.repo.findById(id).orElseThrow()); //error handling
	}
	
	//PUT
		public TdlDTO update(Long id, TdlDomain newDetails) {
			this.repo.findById(id).orElseThrow();
			
			newDetails.setId(id);
			return this.mapToDTO(this.repo.save(newDetails));
		}
	
	//DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
	//
