package com.qa.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //this notifies Spring this class is a controller
@RequestMapping("/cat") //declaring API endpoint
public class CatController {

	//GET
	//URL localhost/cat/helloWorld - invokes the helloWorld method within web browser/postman
	@GetMapping("/helloWorld")
	public String helloWolrd() {
		return "Hello world"; 		
	}
	
	//POST
	
	//PUT
	
	//DELETE
	
	
}
