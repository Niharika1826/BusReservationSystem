package com.bus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.BusDto;
import com.bus.dto.RouteDto;
import com.bus.dto.UserDto;
import com.bus.serviceImplementation.BusService;
import com.bus.serviceImplementation.RouteService;
import com.bus.serviceImplementation.UserService;

@RestController

public class AdminController {
	
	@Autowired
	private BusService busService;
	
    @Autowired
    private UserService userService;
    
    
    
    @Autowired
    private RouteService routeService;
    
  
    
    @PostMapping("/addBus")
	public BusDto addBus(@Valid @RequestBody BusDto busDto) {
		return busService.addBus(busDto);
	}
	
	@PutMapping("/updateBus/{busId}/{name}")
	public BusDto updateBus(@PathVariable ("busId")int busId, @PathVariable("name") String name) {
		return busService.updateBus(busId,name);
	}
	
	@DeleteMapping("/deleteBus/{busId}") 
	public BusDto deletBus(@PathVariable ("busId") int busId){
                return busService.deleteBus(busId);
	}
	
	@GetMapping("/viewUser/{userid}")
	public UserDto viewUser(@PathVariable("userid")int userLoginId) {
		return userService.viewUser(userLoginId);
	}
	
	@GetMapping("/viewAllUsers")
	public List<UserDto> viewAllUsers(){
		return userService.viewAllUsers();
	}
	
	@PostMapping("/addRoute")
	public RouteDto addRoute(@Valid @RequestBody  RouteDto routeDto) {
		return routeService.addRoute(routeDto);
	}
	
	@PutMapping("/updateRoute/{routeId}/{distance}")
	public RouteDto updateRoute(@PathVariable("distance")int distance,@PathVariable("routeId")int routeId) {
		return routeService.updateRoute(routeId,distance);
	}
	@DeleteMapping("/deleteRoute/{routeId}")
	public RouteDto deleteRoute(@PathVariable("routeId")int routeId) {
		return routeService.deleteRoute(routeId);
	}
	
	

}
