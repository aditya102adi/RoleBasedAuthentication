package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	AuthenticationService authenticationService;
	
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	
	@PostMapping("/verify")
	public String getData(@RequestBody LoginRequest loginRequest) {
		
		return authenticationService.verify(loginRequest);
		
		/*String message = authenticationService.verifyRole(getUser);
		return message;*/
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		authenticationService.saveUser(user);
		return "User added";
	}
}
