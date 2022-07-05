package com.cg.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bus;
import com.cg.repository.IBusRepository;


@Service

public class IBusService {
	
	@Autowired
	private IBusRepository iBusRepository;
	
	public Bus addBus(Bus bus) {
		iBusRepository.save(bus);
		return bus;
	}
	
	public Bus updateBus(int busId, String busName) {
		Bus bus = iBusRepository.findById(busId).get();
		  bus.setBusName(busName);
		  iBusRepository.deleteById(busId);
		  iBusRepository.save(bus);
		  return bus;
	}
	
	public Bus deleteBus(int busId) {
		Bus bus = iBusRepository.findById(busId).get();
		iBusRepository.deleteById(busId);
		return bus;
	}
	
	
	public Bus viewBus(int busId) {
		Bus bus = iBusRepository.findById(busId).get();
		return bus;
	}
	
	public List<Bus> viewBusByType(String busType){
	   List<Bus> busList =  iBusRepository.findByBusType(busType);
		return busList;
	}
	
	public List<Bus> viewAllBuses(){
		return iBusRepository.findAll();
	}
}

