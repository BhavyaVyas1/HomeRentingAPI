package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.models.House;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.services.HouseServiceImpl;
import com.example.demo.security.services.UserDetailsServiceImpl;

@SpringBootTest
class HouseRentingSystemApplicationTests {
	
	@Test
	void contextLoads() {
	}
}
