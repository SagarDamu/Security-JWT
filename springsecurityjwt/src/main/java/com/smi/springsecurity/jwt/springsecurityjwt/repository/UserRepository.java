package com.smi.springsecurity.jwt.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smi.springsecurity.jwt.springsecurityjwt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String username);
}
