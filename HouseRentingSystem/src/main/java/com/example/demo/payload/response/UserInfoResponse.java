package com.example.demo.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String email;
	private String contactno;
	private List<String> roles;

	public UserInfoResponse(Long id, String username, String email, String contactno, List<String> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.roles = roles;
	}

}