package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bus;
import com.cg.entity.FeedBack;
import com.cg.entity.Route;
import com.cg.entity.User;
import com.cg.service.IBusService;
import com.cg.service.IFeedBackService;
import com.cg.service.IUserService;
import com.cg.service.ReservationService;
import com.cg.service.RouteService;

@RestController

public class AdminController {
	
	@Autowired
	private IBusService iBusService;
	
    @Autowired
    private IUserService iUserService;
    
    @Autowired
    private IFeedBackService iFeedBackService;
    
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private ReservationService reservationService;
    
    @PostMapping("/addBus")
	public Bus addBus(@RequestBody Bus bus) {
		return iBusService.addBus(bus);
	}
	
	@PutMapping("/updateBus/{busId}/{name}")
	public Bus updateBus(@PathVariable ("busId")int busId, @PathVariable("name") String name) {
		return iBusService.updateBus(busId,name);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public Bus deletBus(@PathVariable ("busId") int busId) {
                return iBusService.deleteBus(busId);
	}
	
   
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return iUserService.addUser(user);
	}
	
	@PutMapping("/updateUser/{userId}/{username}")
	public User updateUser(@PathVariable("userId")int userId,@PathVariable("name")String name) {
     return iUserService.updateUser(userId,name);
	}
	
	@DeleteMapping("/deleteUser/{userLoginId}")
	public User deleteUser(@PathVariable("userLoginId")int userLoginId) {
		return iUserService.deleteUser(userLoginId);
	}
	
	@GetMapping("/viewUser/{userid}")
	public User viewUser(@PathVariable("id")int userLoginId) {
		return iUserService.viewUser(userLoginId);
	}
	
	@GetMapping("/viewAllUsers")
	public List<User>viewAllUsers(){
		return iUserService.viewAllUsers();
	}
	
	@PostMapping("/addRoute")
	public Route addRoute(@RequestBody Route route) {
		return routeService.addRoute(route);
	}
	@PutMapping("/updateRoute/{routeId}/{distance}")
	public Route updateRoute(@PathVariable("distance")int distance,@PathVariable("routeId")int routeId) {
		return routeService.updateRoute(routeId,distance);
	}
	@DeleteMapping("/deleteRoute/{routeId}")
	public Route deleteRoute(@PathVariable("routeId")int routeId) {
		return routeService.deleteRoute(routeId);
	}
	

}
