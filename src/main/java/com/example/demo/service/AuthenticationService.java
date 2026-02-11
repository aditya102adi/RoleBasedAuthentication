package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.enumns.Role;
import com.example.demo.repositry.UserRepositry;


@Service
public class AuthenticationService {
	
	UserRepositry userRepositry;
	
	public AuthenticationService(UserRepositry userRepositry) {
		this.userRepositry = userRepositry;
	}
	
	
	public User verify(String name, String password) {
		User user = userRepositry.findByName(name);
		if(user == null)
			return null;
		
		if(!password.equals(user.getPassword()))
			return null;
		
		return user;
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
