package com.bus.serviceImplementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.BusDto;
import com.bus.entity.Bus;
import com.bus.exceptions.BusNotFoundException;
import com.bus.repository.BusRepository;
import com.bus.service.IBusService;


@Service

public class BusService implements IBusService {
	
	@Autowired
	private BusRepository iBusRepository;
	
	public BusDto addBus(BusDto busDto) {
		Bus bus = new Bus();
		BeanUtils.copyProperties(busDto, bus);
		iBusRepository.save(bus);
		return busDto;
	}
	
	public BusDto updateBus(int busId, String busName) {
		if(!iBusRepository.existsById(busId)) {
			throw new BusNotFoundException();
		}
		  Bus bus = iBusRepository.findById(busId).get();
		  BusDto busDto = new BusDto();
		  bus.setBusName(busName);
		  iBusRepository.deleteById(busId);
		  BeanUtils.copyProperties(bus, busDto);
		  iBusRepository.save(bus);
		  return busDto;
		}
	
	
	public BusDto deleteBus(int busId) {
		if(!iBusRepository.existsById(busId)) {
			throw new BusNotFoundException();
		}
        BusDto busDto = new BusDto();
		Bus bus = iBusRepository.findById(busId).get();
		iBusRepository.deleteById(busId);
		BeanUtils.copyProperties(bus, busDto);
		return busDto;
		
	}
	
	
	public BusDto viewBus(int busId) {
		if(!iBusRepository.existsById(busId)) {
			throw new BusNotFoundException();
		}
		BusDto busDto = new BusDto();
		Bus bus = iBusRepository.findById(busId).get();
		BeanUtils.copyProperties(bus, busDto);
		return busDto;
	}
	
	public List<BusDto> viewBusByType(String busType){
		if(iBusRepository.findByBusType(busType)!=null) {
			throw new BusNotFoundException();
		}
		BusDto busDto = new BusDto();
		List<BusDto> busDtoList = new ArrayList<>();
	    List<Bus> busList =  iBusRepository.findByBusType(busType);
	    for(Bus bus : busList) {
	    	BeanUtils.copyProperties(bus, busDto);
	    	busDtoList.add(busDto);
	    }
		return busDtoList;
	}
	
	public List<BusDto> viewAllBuses(){
		
        List<Bus> busList = iBusRepository.findAll();
        List<BusDto> busDtoList = new ArrayList<>();
        BusDto busDto = new BusDto();
        for(Bus bus : busList) {
        	BeanUtils.copyProperties(bus, busDto);
        	busDtoList.add(busDto);
        }
        return busDtoList;
	}
}

