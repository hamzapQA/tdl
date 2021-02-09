package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.TdlDomain;

//this is an interface
@Repository
public interface TdlRepo extends JpaRepository<TdlDomain, Long> {

	//Provides CRUD in H2 database
}
//