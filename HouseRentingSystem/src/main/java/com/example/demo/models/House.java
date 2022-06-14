package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
@ToString
@Table(name = "house")
public class House {

	@Id
	@Column(name = "id")
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
	
	@Column(name = "house_type")
	private String houseType;

	@Column(name = "house_description")
	private String houseDescription;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String houseimage;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "HouseInfo", joinColumns = @JoinColumn(name = "house_id"),
	 * inverseJoinColumns = @JoinColumn(name = "user_id")) private Set<User>
	 * username = new HashSet<>();
	 */

	public House() {

	}

	public House(String houseName, String houseAddress, Long houseRent, String houseContactno, String houseType,
			String houseDescription) {
		this.houseName = houseName;
		this.houseAddress = houseAddress;
		this.houseRent = houseRent;
		this.houseContactno = houseContactno;
		this.houseType = houseType;
		this.houseDescription = houseDescription;
	}

}
