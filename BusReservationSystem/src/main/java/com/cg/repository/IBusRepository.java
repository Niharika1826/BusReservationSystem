package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Bus;



public interface IBusRepository extends JpaRepository<Bus,Integer> {

	 public List<Bus> findByBusType(String busType);

	
	

}
