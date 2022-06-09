package com.example.demo.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class SignUpRequest {
	
	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    @NotBlank
    @Size(min = 10, max = 10)
    private String contactno;
    
}
