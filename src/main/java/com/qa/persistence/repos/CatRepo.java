package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Cat;

//this is an interface
@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {

	//Provides CRUD in H2 database
}
