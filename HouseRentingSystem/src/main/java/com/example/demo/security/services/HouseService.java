package com.example.demo.security.services;

import java.io.IOException;
import java.util.Base64;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.HouseDao;
import com.example.demo.entity.House;

@Service
public class HouseService {

	@Autowired
	private HouseDao houseDao;

	public void saveHouseToDB(MultipartFile file, String houseName, String houseAddress, double houseRent) {



		House h = new House();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			h.setHouseimage(Base64.getEncoder().encodeToString(file.getBytes()));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		h.setHouseAddress(houseAddress);
		h.setHouseName(houseName);
		h.setHouseRent(houseRent);
		houseDao.save(h);

		}
	
	public Iterable<House> getAllHouse() {
		return houseDao.findAll();
	}

	public void deleteHouseById(Long id) {
		houseDao.deleteById(id);
	}

	public void changeHouseName(Long id, String houseName) {
		House h = new House();
		h = houseDao.findById(id).get();
		h.setHouseName(houseName);
		houseDao.save(h);
	}

	public void changeHouseAddress(Long id, String houseAddress) {
		House h = new House();
		h = houseDao.findById(id).get();
		h.setHouseAddress(houseAddress);
		houseDao.save(h);
	}

	public void changeHouseRent(Long id, Double houseRent) {
		House h = new House();
		h = houseDao.findById(id).get();
		h.setHouseRent(houseRent);
		houseDao.save(h);
	}
}
