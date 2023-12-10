package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.models.User;

import jakarta.validation.Valid;

@RestController
public class HomeController {

	@Autowired private MyUserDetailsService userService;
	
	@GetMapping("/")
	public String sayWelcome() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping("/user")
	public String sayWelcomeUser() {
		return "<h1>Welcome User</h1>";
	}
	
	@GetMapping("/admin")
	public String sayWelcomeAdmin() {
		return "<h1>Welcome Admin</h1>";
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		
	}
}
