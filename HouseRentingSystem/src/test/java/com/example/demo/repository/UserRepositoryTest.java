package com.example.demo.repository;

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

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.models.User;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveUserTest() {
	      User user =User.builder()
	    		  .username("bhavya7")
	    		  .email("bhavya7@gmail.com")
	    		  .password("bhavya7@123")
	    		  .contactno("9876543543")
	    		  .build();
	      
	      userRepository.save(user);
	      
	      Assertions.assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getUserList() {
		
		User user = userRepository.findById(18L).get();
		
		Assertions.assertThat(user.getId()).isEqualTo(18L);
	}
	
	@Test
	@Order(3)
	public void getListOfUserTest() {
		List<User> user = userRepository.findAll();
		
		Assertions.assertThat(user.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateUserTest()
	{
		User user = userRepository.findById(18L).get();
		user.setUsername("Bhavya21");
		User userUpdated = userRepository.save(user);
		Assertions.assertThat(userUpdated.getUsername()).isEqualTo("Bhavya21");
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteUserTest() {
		User user = userRepository.findById(18L).get();
		
		userRepository.deleteById(18L);
		
		User user1 = null;
		
		Optional<User> optionalUser = userRepository.findByUsername("Bhavya21");
		
		if(optionalUser.isPresent()) {
			user1 = optionalUser.get();
		}
		
		Assertions.assertThat(user1).isNull();
	}
}
