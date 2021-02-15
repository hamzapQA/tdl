package com.qa.rest;

import java.util.List;

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

import com.qa.persistence.domain.MemberDomain;
import com.qa.persistence.dtos.MemberDTO;
import com.qa.services.MemberService;
//mapping for API endpoints for Member entity
@RestController
@RequestMapping("/task")
public class MemberController {
	
	private MemberService service;

	public MemberController(MemberService service) {
		super();
		this.service = service;
		
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<MemberDTO>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<MemberDTO> readByTaskId(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.service.readById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<MemberDTO> create(@RequestBody MemberDomain model){
		return new ResponseEntity<MemberDTO>(this.service.create(model), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MemberDTO> updateTask(@PathVariable("id") Long id, @RequestBody MemberDomain model){
		return ResponseEntity.ok(this.service.updateTask(id, model));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable("id") Long id){
		return this.service.deleteTask(id)?
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
