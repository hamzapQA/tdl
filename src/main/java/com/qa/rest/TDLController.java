package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.persistence.domain.TDLDomain;
import com.qa.persistence.dtos.TDLDTO;
import com.qa.services.TDLService;
//mapping for API endpoints for Todolist entity
@RestController
@RequestMapping("/todo")
public class TDLController {

	private TDLService service;

	@Autowired
	public TDLController(TDLService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<TDLDTO>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	
	
	@GetMapping("/read/{id}")
	public ResponseEntity<TDLDTO> readByToDoId(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.service.readById(id));
	}
		
	
	
	
	@PostMapping("/create")
	public ResponseEntity<TDLDTO> create(@RequestBody TDLDomain model){
		return new ResponseEntity<TDLDTO>(this.service.create(model), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TDLDTO> updateByHouseId(@PathVariable("id") Long id, @RequestBody TDLDomain model){
		return ResponseEntity.ok(this.service.updateToDo(id, model));
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteHouse(@PathVariable("id") Long id){
		return this.service.deleteToDo(id) ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
