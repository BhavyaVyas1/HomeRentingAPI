package com.example.demo.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class LoginRequest {
	
	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
