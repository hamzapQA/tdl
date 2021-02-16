package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.MemberDomain;

@Repository
public interface MemberRepo extends JpaRepository<MemberDomain, Long>{

}
