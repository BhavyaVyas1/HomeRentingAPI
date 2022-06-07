package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.HouseDao;
import com.example.demo.entity.House;
import com.example.demo.security.services.HouseService;

@RestController
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseDao houseRepo;
	
	@RequestMapping("/home")
	public String ShowHouse() {
		return "Add house successfull";
	}
	
	@GetMapping("/listHouses")
	public String showExampleView()
	{
//		ModelAndView mv=new ModelAndView();
//		Iterable<House> houses = houseService.getAllHouse();
		//model.addAttribute("houses", houses);
//		mv.addObject("houses",houses);
//		mv.setViewName("listHouses.html");
		return "list house" ;
	}
    
    @PostMapping("/addHouse")
    public String saveHouse(@RequestParam("houseImage") MultipartFile file,
    		@RequestParam("houseName") String name,
    		@RequestParam("houseRent") double rent,
    		@RequestParam("houseAddress") String address)
    {
    	houseService.saveHouseToDB(file, name, address, rent);
//    	ModelAndView mv=new ModelAndView();
//		mv.setViewName("listHouses.html");
		return "house added";
    	
    	//return "redirect:/listHouses.html";
    }
    
    @GetMapping("/deleteHouse/{id}")
    public String deleteHouswe(@PathVariable("id") Long id)
    {
    	
    	houseService.deleteHouseById(id);
    	return "house deleted successfully";
    }
    
    @PostMapping("/changeName")
    public String changeHname(@RequestParam("id") Long id,
    		@RequestParam("newHname") String name)
    {
    
    	houseService.changeHouseName(id, name);
    	return "house name change successfully";
    }
    @PostMapping("/changeAddress")
    public String changeAddress(@RequestParam("id") Long id ,
    		@RequestParam("newAddress") String address)
    {
    	houseService.changeHouseAddress(id, address);
    	return "house address changed successfully";
    }
    
    @PostMapping("/changeRent")
    public String changeRent(@RequestParam("id") Long id ,
    		@RequestParam("newRent") Double rent)
    {
    	houseService.changeHouseRent(id, rent);
    	return "house rent changed successfully";
    }

}
