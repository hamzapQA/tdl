package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Cat;

@RestController //this notifies Spring this class is a controller
@RequestMapping("/cat") //declaring API endpoint
public class CatController {

	private List<Cat> catList = new ArrayList<>();

	//GET
	//URL http://localhost:8080/cat/helloWorld - invokes the helloWorld method within web browser/postman
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world"; 		
	}
	
	@GetMapping("/getCats")				
	public List<Cat> readAll() {
		return catList;
	}
	
	//POST					//when posting via Postman, must go to Body -> Txt -> Dropdown JSON
	@PostMapping("/create")
	public boolean create(@RequestBody Cat cat) {
		return catList.add(cat);
	}
	
	//PUT
	
	//DELETE
	
	
}
