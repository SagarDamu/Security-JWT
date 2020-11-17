package com.smi.springsecurity.jwt.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smi.springsecurity.jwt.springsecurityjwt.model.User;
import com.smi.springsecurity.jwt.springsecurityjwt.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
	
	UserDetails findByUserName(String username);
	
}
