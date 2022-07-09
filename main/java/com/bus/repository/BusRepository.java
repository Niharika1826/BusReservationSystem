package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Bus;



public interface BusRepository extends JpaRepository<Bus,Integer> {

	 public List<Bus> findByBusType(String busType);

	 
	

}
