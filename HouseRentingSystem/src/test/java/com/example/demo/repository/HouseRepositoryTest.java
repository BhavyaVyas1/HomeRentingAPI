package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HouseRepositoryTest {
	
	@Autowired
	HouseRepository houseRepo;
	
	@Test
	void isHouseExistsById(){
		Boolean actualResult = houseRepo.isHouseExistsById(1);
        assertThat(actualResult).isTrue();
	}

}
