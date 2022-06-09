package com.example.demo.payload.response;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class UserInfoResponse {
	
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private String contactno;

	public UserInfoResponse(Long id, String username, String email, List<String> roles, String contactno) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.contactno = contactno;
	}

}
