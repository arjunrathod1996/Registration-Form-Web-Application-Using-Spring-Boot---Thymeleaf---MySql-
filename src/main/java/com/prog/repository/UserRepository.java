package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
	public UserDetails findByEmail(String em);
	
	
}
