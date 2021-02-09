package com.qa.rest;

import java.util.ArrayList;
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

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.dtos.CatDTO;
import com.qa.services.CatService;

@RestController //this notifies Spring this class is a controller
@RequestMapping("/cat") //declaring API endpoint
public class CatController {

	private CatService service;
	
//referencing CatService entity in repo, creating constructor
	
	@Autowired //used for constructor, passed to CatService for bean to be generated
	public CatController(CatService service) { //dependency injection, parameter must be passed 
		super();
		this.service = service;
	}

	//GET
	//URL http://localhost:8080/cat/helloWorld - invokes the helloWorld method within web browser/postman
	//@GetMapping("/helloWorld")
	//public String helloWorld() {
	//	return "Hello world"; 		
	//}
	
	//GET - Read all 
	@GetMapping("/readAll")
	public ResponseEntity<List<CatDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	
	//GET (Read by ID)
	@GetMapping("/read/{id}")
	public ResponseEntity <CatDTO> readCat(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	//POST (CREATE)
	@PostMapping("/create")
	public ResponseEntity<CatDTO> create(@RequestBody CatDomain cat) {
		return new ResponseEntity<CatDTO>(this.service.create(cat), HttpStatus.CREATED); //changing the HTTP response code
	}																					 //this gives code 201 instead of the generic 200
	
	//PUT (UPDATE)
			@PutMapping("update/{id}")
			public ResponseEntity<CatDTO> update(@PathVariable("id") Long id, @RequestBody CatDomain cat) {
				return new ResponseEntity<CatDTO>(this.service.update(id, cat), HttpStatus.ACCEPTED);
			}

	//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
		return this.service.delete(id) ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
}
