package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Cat;
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
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world"; 		
	}
	
	@GetMapping("/readAll")
	public List<Cat> readAll() {
		return null;
	}
	
	@GetMapping("/read/{id}")
	public Cat readCat(@PathVariable("id") Long id) {
		return null;
	}
	
	//POST (CREATE)
	@PostMapping("/create")
	public Cat create(@RequestBody Cat cat) {
		return this.service.create(cat);
	}
	
	//PUT (UPDATE)
	@PutMapping("update/{id}")
	public boolean update(@PathVariable("id") Long id, @RequestBody Cat cat) {
		return false;
	}

	//DELETE
	@DeleteMapping("/delete/{id}")
	public boolean update(@PathVariable("id") Long id) {
		return false;
	}
	
}
