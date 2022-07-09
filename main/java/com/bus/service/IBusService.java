package com.bus.service;

import java.util.List;

import com.bus.dto.BusDto;

public interface IBusService {

	public BusDto addBus(BusDto busDto);
	public BusDto updateBus(int busId, String busName);
	public BusDto deleteBus(int busId);
	public BusDto viewBus(int busId);
	public List<BusDto> viewBusByType(String busType);
	public List<BusDto> viewAllBuses();
}
