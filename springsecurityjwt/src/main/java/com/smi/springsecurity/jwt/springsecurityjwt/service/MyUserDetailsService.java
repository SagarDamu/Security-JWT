package com.smi.springsecurity.jwt.springsecurityjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smi.springsecurity.jwt.springsecurityjwt.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.smi.springsecurity.jwt.springsecurityjwt.model.UserDetails user = userRepository.findByUserName(username);
		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
		
		// com.smi.springsecurity.jwt.springsecurityjwt.model.UserDetails user =
		// userRepository.findByUserName(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("Not found");
//		}
//		return new UserPrincipal(user);

	}

}
