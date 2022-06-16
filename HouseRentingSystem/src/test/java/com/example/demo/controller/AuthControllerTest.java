package com.example.demo.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.AuthController;
import com.example.demo.controllers.HouseController;
import com.example.demo.models.User;
import com.example.demo.security.services.HouseServiceImpl;
import com.example.demo.security.services.UserDetailsImpl;

@RunWith(SpringRunner.class)
public class AuthControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	AuthController authController;

	@Mock
	UserDetailsImpl userDetailsImpl;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
	}

	@Test
	public void registerUser() throws Exception {
		String jsonString = "{\n" + "\"id\":1,\n" + "\"username\":\"customer3\",\n" + "\"email\":\"customer3@ohrs.com\"\n"
				+ "\"password\":\"customer3@123\",\n" + "\"contactno\":\"9876543212\",\n" +"}";
		User user = new User(1L,"customer3","customer3@ohrs.com","customer3@123","9876543213",null);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("1")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("customer3")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("customer3@ohrs.com")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("customer3@123")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.contactno", Matchers.is("9876543212")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.role", Matchers.is("customer")));
	}

}
