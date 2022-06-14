package com.example.demo.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repository.HouseRepository;
import com.example.demo.security.services.HouseService;
import com.example.demo.security.services.HouseServiceImpl;

@ExtendWith(MockitoExtension.class)

public class HouseServiceTest {

	@Mock
	private HouseRepository houseRepo;

	private HouseServiceImpl houseServiceImpl;

	@BeforeEach
	void setUp() {
		this.houseServiceImpl = new HouseServiceImpl(this.houseRepo);
	}

	@Test
	void fetchHouseList() {
		houseServiceImpl.fetchHouseList();
		verify(houseRepo).findAll();
	}

}
