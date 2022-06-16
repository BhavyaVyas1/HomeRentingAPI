package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.HouseController;
import com.example.demo.models.House;
import com.example.demo.repository.HouseRepository;
import com.example.demo.security.services.HouseService;
import com.example.demo.security.services.HouseServiceImpl;

@RunWith(SpringRunner.class)
public class HouseControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	HouseController houseController;

	@Mock
	HouseServiceImpl houseServiceImpl;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(houseController).build();
	}

	@Test
	public void fetchHouseList() throws Exception {
		List<House> houses = Arrays.asList(
				new House("Sukoon Bungalows", "Thaltej Ahmedabad", 3600L, "9876543213", "Bungalow", "For Bachelors"));

		Mockito.when(houseServiceImpl.fetchHouseList()).thenReturn(houses);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/houses")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	

	@Test
	public void deleteHouseById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/houses/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
