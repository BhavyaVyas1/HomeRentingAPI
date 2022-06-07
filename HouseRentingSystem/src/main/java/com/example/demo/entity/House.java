package com.example.demo.entity;

import javax.persistence.*;


import com.fasterxml.jackson.core.util.ByteArrayBuilder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data@ToString
@Getter@Setter
@Table(name="house_table" )
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "house_name")
	private String houseName;

	@Column(name = "house_rent")
	private Double houseRent;

	@Column(name = "house_address")
	private String houseAddress;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String houseimage;
	
	

}
