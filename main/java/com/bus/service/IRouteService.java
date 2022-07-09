package com.bus.service;

import java.util.List;

import com.bus.dto.RouteDto;

public interface IRouteService {

	public RouteDto addRoute(RouteDto routeDto) ;
	public RouteDto updateRoute(int routeId,int distance);
	public RouteDto deleteRoute(int routeId);
	public RouteDto viewRoute(int routeId);
	public List<RouteDto> viewAllRoutes();
}
