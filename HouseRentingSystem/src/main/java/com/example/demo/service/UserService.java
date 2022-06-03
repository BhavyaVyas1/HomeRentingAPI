package com.example.demo.service;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public User registerNewUser(User user) {
		return userDao.save(user);
		
	}
	
	public void initAdminandUser() {
		
		Role adminRole =new Role();
		adminRole.setRolename("Admin");
		adminRole.setRoledescription("Admin ROLE");
		roleDao.save(adminRole);
		
		Role ownerRole =new Role();
		ownerRole.setRolename("Owner");
		ownerRole.setRoledescription("Owner ROLE");
		roleDao.save(ownerRole);
		
		User admin = new User();
		admin.setUserName("Admin");
		admin.setEmail("rajesh1@gmail.com");
		admin.setPassword("rajesh@123");
		admin.setContectNo("987897897");
		Set<Role> adminRoles = new HashSet<>(); 
		adminRoles.add(adminRole);
		admin.setRoles(adminRoles);
		userDao.save(admin);
		
		User owner = new User();
		owner.setUserName("owner");
		owner.setEmail("owner@gmail.com");
		owner.setPassword("owner@123");
		owner.setContectNo("987897897");
		Set<Role> ownerRoles = new HashSet<>(); 
		ownerRoles.add(ownerRole);
		owner.setRoles(ownerRoles);
		userDao.save(owner);
		
		
		
	}

}
