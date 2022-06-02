package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@Data
@ToString
public class Role {
	
	@Id
	private String rolename;
	private String roledescription;
	

}
