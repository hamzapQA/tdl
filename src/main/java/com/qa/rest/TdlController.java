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

import com.qa.persistence.domain.TdlDomain;
import com.qa.persistence.dtos.TdlDTO;
import com.qa.services.TdlService;

@RestController //this notifies Spring this class is a controller
@RequestMapping("/tdl") //declaring API endpoint
public class TdlController {

	private TdlService service;
	
//referencing CatService entity in repo, creating constructor
	
	@Autowired //used for constructor, passed to CatService for bean to be generated
	public TdlController(TdlService service) { //dependency injection, parameter must be passed 
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
	public ResponseEntity<List<TdlDTO>> readAllItems() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	
	//GET (Read by ID)
	@GetMapping("/read/{id}")
	public ResponseEntity <TdlDTO> readItem(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	//POST (CREATE)
	@PostMapping("/create")
	public ResponseEntity<TdlDTO> createItem(@RequestBody TdlDomain item) {
		return new ResponseEntity<TdlDTO>(this.service.create(item), HttpStatus.CREATED); //changing the HTTP response code
	}																					 //this gives code 201 instead of the generic 200
	
	//PUT (UPDATE)
			@PutMapping("update/{id}")
			public ResponseEntity<TdlDTO> updateItem(@PathVariable("id") Long id, @RequestBody TdlDomain item) {
				return new ResponseEntity<TdlDTO>(this.service.update(id, item), HttpStatus.ACCEPTED);
			}

	//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteItem(@PathVariable("id")Long id) {
		return this.service.delete(id) ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	//
}
