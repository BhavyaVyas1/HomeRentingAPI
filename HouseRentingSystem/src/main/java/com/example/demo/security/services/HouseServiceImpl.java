package com.example.demo.security.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.House;
import com.example.demo.repository.HouseRepository;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseRepository houseRepository;

	// Save operation
	@Override
	public House saveHouse(House house) {
		
		return houseRepository.save(house);
	}

	// Read operation
	@Override
	public List<House> fetchHouseList() {
		return (List<House>) houseRepository.findAll();
	}

	// Update operation
	@Override
	public House updateHouse(House house, Long houseId) {
		
		House houseDB = houseRepository.findById(houseId).get();

		
		if (Objects.nonNull(house.getHouseName()) && !"".equalsIgnoreCase(house.getHouseName())) {
			houseDB.setHouseName(house.getHouseName());
		}
		
		if (Objects.nonNull(house.getHouseAddress()) && !"".equalsIgnoreCase(house.getHouseAddress())) {
			houseDB.setHouseAddress(house.getHouseAddress());
		}
		
		if (Objects.nonNull(house.getHouseRent()) && !"".equals(house.getHouseRent())) {
			houseDB.setHouseRent(house.getHouseRent());
		}
		
		if (Objects.nonNull(house.getHouseContactno()) && !"".equalsIgnoreCase(house.getHouseContactno())) {
			houseDB.setHouseContactno(house.getHouseContactno());
		}
		
		if (Objects.nonNull(house.getHouseDescription()) && !"".equalsIgnoreCase(house.getHouseDescription())) {
			houseDB.setHouseDescription(house.getHouseDescription());
		}
		

		return houseRepository.save(houseDB);
	}

	// Delete operation
	@Override
	public void deleteHouseById(Long houseId) {
		houseRepository.deleteById(houseId);
	}
}
