package com.example.demo.security.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.House;

public interface HouseService {
	
	House saveHouse(MultipartFile file,String housename, String houseAddress, 
			Long houseRent, String houseContactno, String houseType, String houseDescription);
	 
    // Read operation
	List<House> fetchHouseList();
 
    // Update operation
    House updateHouse(House house,Long houseId);
 
    // Delete operation
    void deleteHouseById(Long houseId);

}
