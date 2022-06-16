package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.House;
import com.example.demo.models.User;
import com.example.demo.security.services.HouseService;

@RestController
@RequestMapping("/api")
public class HouseController {
	@Autowired 
	private HouseService houseService;
	
	@GetMapping("/index")
	@PreAuthorize("hasRole('OWNER')")	
	public String moderatorAccess() {
		return "Hi owner, you can add house";
	}
	
	// Save operation
    @PostMapping("/houses")
    @PreAuthorize("hasRole('OWNER')")
    public House saveHouse(@RequestParam("file") MultipartFile file,
    		@RequestParam("hname") String houseName,
    		@RequestParam("haddress") String houseAddress,
    		@RequestParam("hrent") Long houseRent,
    		@RequestParam("hcontact") String houseContactno,
    		@RequestParam("htype") String houseType,
    		@RequestParam("hdescription") String houseDescription)
    {
    	return houseService.saveHouse(file, houseName, houseAddress, houseRent, houseContactno, houseType, houseDescription);
    	//return houseService.saveHouse(house);
    }
	
    // Read operation
    @GetMapping("/houses")
    public List<House> fetchHouseList()
    {
    	return houseService.fetchHouseList();
    }
    
    // Update operation
    @PutMapping("/houses/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public House updateHouse(@RequestBody House house, @PathVariable("id") Long HouseId)
    {
    	return houseService.updateHouse(house, HouseId);
    }
    
    // Delete operation
    @DeleteMapping("/houses/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public String deleteHouseById(@PathVariable("id") Long houseId)
    {
    	houseService.deleteHouseById(houseId);
        return "Deleted Successfully";
    }
}
