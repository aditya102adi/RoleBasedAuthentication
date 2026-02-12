package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.enumns.Role;
import com.example.demo.repositry.UserRepositry;


@Service
public class AuthenticationService {
	
	UserRepositry userRepositry;
	
	public AuthenticationService(UserRepositry userRepositry) {
		this.userRepositry = userRepositry;
	}
	
	
	public String verify(LoginRequest loginRequest) {
		
		User user = userRepositry.findByName(loginRequest.getName()).orElse(null);
		
		// If the user is not found or if password is wrong
		if(user == null || !user.getPassword().equals(loginRequest.getPassword()))
			return "Invalid Credentials";
		
		
		return verifyRole(user);
	}
	
	public String verifyRole(User user) {
		
		if (user.getRole() == Role.ADMIN)
			return "Welcome to Admin Page";
		
		return "Welcome to User Page";
	}
	
	
	public void saveUser(User user) {
		userRepositry.save(user);
	}
}
