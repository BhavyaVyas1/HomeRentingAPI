package com.example.demo.security.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.House;
import com.example.demo.repository.HouseRepository;
import org.springframework.util.StringUtils;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseRepository houseRepository;

	public HouseServiceImpl(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	// Save operation
	@Override
	public House saveHouse(MultipartFile file, String housename, String houseAddress, Long houseRent,
			String houseContactno, String houseType, String houseDescription) {

		House h = new House();

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			h.setHouseimage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		h.setHouseName(housename);
		h.setHouseAddress(houseAddress);
		h.setHouseRent(houseRent);
		h.setHouseContactno(houseContactno);
		h.setHouseType(houseType);
		h.setHouseDescription(houseDescription);
		return houseRepository.save(h);
	}

	// Read operation
	@Override
	public List<House> fetchHouseList() {
		List<House> houses = houseRepository.findAll();
		System.out.println("Getting data from DB:" + houses);
		//return (List<House>) houseRepository.findAll();
		return houses;
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

		if (Objects.nonNull(house.getHouseType()) && !"".equalsIgnoreCase(house.getHouseType())) {
			houseDB.setHouseType(house.getHouseType());
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
