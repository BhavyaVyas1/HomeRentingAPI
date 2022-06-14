package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM House h WHERE h.id = ?1")
	
	Boolean isHouseExistsById(Integer id);
}
