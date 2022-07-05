package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Route;
import com.cg.repository.RouteRepository;

@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepository;

	
	public Route addRoute(Route route) {
		routeRepository.save(route);
		return route;
	}

	public Route updateRoute(int routeId,int distance) {
		Route route = routeRepository.findById(routeId).get();
		route.setDistance(distance);
		routeRepository.deleteById(routeId);
		routeRepository.save(route);
		return route;
	}
	public Route deleteRoute(int routeId) {
		Route route = routeRepository.findById(routeId).get();
		routeRepository.deleteById(routeId);
		return route;
	}

	
	public Route viewRoute(int routeId) {
		Route route= routeRepository.findById(routeId).get();
		return route;
	}

	
	public List<Route> viewAllRoutes() {
		return routeRepository.findAll();
	}

	}
