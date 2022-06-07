package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.House;

@Repository
public interface HouseDao extends CrudRepository<House, Long>{

}
