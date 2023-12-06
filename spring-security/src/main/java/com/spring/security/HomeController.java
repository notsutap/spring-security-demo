package com.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

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
}
