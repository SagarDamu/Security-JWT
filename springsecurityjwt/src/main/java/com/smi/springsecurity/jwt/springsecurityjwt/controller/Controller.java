package com.smi.springsecurity.jwt.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smi.springsecurity.jwt.springsecurityjwt.model.AuthRequest;
import com.smi.springsecurity.jwt.springsecurityjwt.utility.JwtUtility;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	JwtUtility jwtUtility;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping("/")
	public String home() {
		return "Welcome to JWT";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid Username or Password");
		}

		return jwtUtility.generateToken(authRequest.getUserName());
	}

}
