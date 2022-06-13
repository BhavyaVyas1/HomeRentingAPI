package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.House;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/owner")
	@PreAuthorize("hasRole('OWNER')")
	public String moderatorAccess() {
		return "Owner Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/userlist")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> fetchUserList() {
		return (List<User>) userRepository.findAll();
	}
}
