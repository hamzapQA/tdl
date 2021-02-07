package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.CatDomain;

//this is an interface
@Repository
public interface CatRepo extends JpaRepository<CatDomain, Long> {

	//Provides CRUD in H2 database
}
