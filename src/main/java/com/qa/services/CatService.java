package com.qa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.persistence.domain.Cat;
import com.qa.persistence.repos.CatRepo;
//this method is designed to use the cat controller 
@Service
public class CatService {

	private CatRepo repo;

	@Autowired
	public CatService(CatRepo repo) {
		super();
		this.repo = repo;
	}
	
	//POST (CREATE)
	public Cat create(Cat cat) {
		return this.repo.save(cat);
	}
	

	
}
