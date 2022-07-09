package com.bus.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.RouteDto;
import com.bus.entity.Route;
import com.bus.exceptions.RouteNotFoundException;
import com.bus.repository.RouteRepository;
import com.bus.service.IRouteService;

@Service
public class RouteService implements IRouteService {

	@Autowired
	private RouteRepository routeRepository;

	
	public RouteDto addRoute(RouteDto routeDto) {
		Route route = new Route();
		BeanUtils.copyProperties(routeDto, route);
		routeRepository.save(route);
		return routeDto;
	}

	public RouteDto updateRoute(int routeId,int distance) {
		if(!routeRepository.existsById(routeId)) {
			throw new RouteNotFoundException();
		}
		RouteDto routeDto =new RouteDto();
		Route route = new Route();
		route = routeRepository.findById(routeId).get();
		BeanUtils.copyProperties(route, routeDto);
        routeDto.setDistance(distance);
		BeanUtils.copyProperties(routeDto, route);
		routeRepository.save(route);
		routeRepository.flush();
	    return routeDto;
		
	}
	public RouteDto deleteRoute(int routeId) {
		
		if(!routeRepository.existsById(routeId)) {
			throw new RouteNotFoundException();
		}
		
		RouteDto routeDto = new RouteDto();
		Route route =new Route();
		route = routeRepository.findById(routeId).get();
		BeanUtils.copyProperties(route, routeDto);
		routeRepository.deleteById(routeId);
		return routeDto;
	}

	
	public RouteDto viewRoute(int routeId) {
		
		if(!routeRepository.existsById(routeId)) {
			throw new RouteNotFoundException();
		}

		RouteDto routeDto = new RouteDto();
		Route route =new Route();
		route=routeRepository.findById(routeId).get();
		BeanUtils.copyProperties(route, routeDto);
		return routeDto;
	}

	
	public List<RouteDto> viewAllRoutes() {
		List<RouteDto>routeDtoList=new ArrayList<>();
		List<Route>routeList=routeRepository.findAll();
		RouteDto routeDto=new RouteDto();
		for(Route route:routeList) {
			BeanUtils.copyProperties(route, routeDto);
			routeDtoList.add(routeDto);
		}
		return routeDtoList;

	}
	}

	
