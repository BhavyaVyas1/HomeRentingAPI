package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "house")
public class House {

	
	@Id
	@Column(name = "house_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long houseId;
	
	@Column(name = "house_name")
	private String houseName;
	
	
	@Column(name = "house_address")
	private String houseAddress;
	
	@Column(name = "house_rent")
	private Long houseRent;
	
	@Column(name = "contact_no")
	private String houseContactno;
	
	@Column(name = "house_description")
	private String houseDescription;

	@Lob
	@Column(name = "house_image", unique = false, length = 100000)
	private byte[] houseImage;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "HouseInfo", joinColumns = @JoinColumn(name = "house_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private Set<User> username = new HashSet<>();
}
