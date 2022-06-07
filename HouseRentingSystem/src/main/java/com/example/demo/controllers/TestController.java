package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	/*@GetMapping("/user")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('OWNER') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	} */
	
	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String customerAccess() {
		return "Welcome! You are at customer board.";
	}
	
	@GetMapping("/owner")
	@PreAuthorize("hasRole('owner')")
	public String ownerAccess() {
		return "Welcome! You are at owner board.";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('admin')")
	public String adminAccess() {
		return "Admin Board.";
	}
}


