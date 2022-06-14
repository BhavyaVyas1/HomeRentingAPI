package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.models.House;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HouseRepositoryTest {
	
	@Autowired
	HouseRepository houseRepository;
	
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveHouseTest(){
		
		House house = House.builder()
				.houseName("Rensi Vila 4")
				.houseAddress("Gurudwara Road,Ahmedabad")
				.houseRent(2300L)
				.houseContactno("9321456743")
				.houseType("3BHK vila")
				.houseDescription("For Students")
				.houseimage("C:\\Users\\150233\\Downloads\\img9.jpg")
				.build();
		
		houseRepository.save(house);
		Assertions.assertThat(house.getHouseId()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(2)
	public void getHouseTest() {
		House house = houseRepository.findById(4L).get();
		Assertions.assertThat(house.getHouseId()).isEqualTo(4L);
	}
	
	@Test
	@Order(3)
	public void getListOfHouseTest() {
		List<House> house = houseRepository.findAll();
		Assertions.assertThat(house.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void updateHouseList() {
		House house = houseRepository.findById(4L).get();
		
		house.setHouseName("Rensi Bhavan");
		
		House houseUpdated = houseRepository.save(house);
		
		Assertions.assertThat(houseUpdated.getHouseName()).isEqualTo("Rensi Bhavan");
		
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteHouseList() {
		House house = houseRepository.findById(3L).get();
		
		houseRepository.delete(house);
		
		House house1 = null;
		
		Optional<House> optionalHouse = houseRepository.findByHouseName("Rensi Vila 3");
		
		if(optionalHouse.isPresent()) {
			house1 = optionalHouse.get();
		}
		
		Assertions.assertThat(house1).isNull();
	}
	
}
