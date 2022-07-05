package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bus;
import com.cg.entity.FeedBack;
import com.cg.entity.Route;
import com.cg.service.IBusService;
import com.cg.service.IFeedBackService;
import com.cg.service.IUserService;
import com.cg.service.ReservationService;
import com.cg.service.RouteService;

@RestController
public class AdminAndUserController {
	
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

    @GetMapping("/viewAllBuses")
	public List<Bus> viewAllBus(){
		return iBusService.viewAllBuses();
	}
    
	@GetMapping("/viewBus/{busId}")
	public Bus viewBus(@PathVariable ("busId") int busId) {
	return iBusService.viewBus(busId);
    }

	@GetMapping("/viewBusByType/{busType}")
    public List<Bus> viewBusByType(@PathVariable("busType") String busType){
	  return iBusService.viewBusByType(busType);
  }
	@GetMapping("/viewAllRoutes")
 	public List<Route> viewAllroute() {
 		return routeService.viewAllRoutes();
 	}
     @GetMapping("/viewRoute/{routeId}")
 	public Route viewRoute(@PathVariable("routeId") int routeId) {
 		return routeService.viewRoute(routeId);
 	}
     @GetMapping("/viewAllFeedBacks")
     public List<FeedBack> viewAllFeedBack(){
	 return iFeedBackService.viewAllFeedBack();
   }


}
