package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bus;
import com.cg.entity.FeedBack;
import com.cg.entity.Reservation;
import com.cg.entity.Route;
import com.cg.service.IBusService;
import com.cg.service.IFeedBackService;
import com.cg.service.ReservationService;
import com.cg.service.RouteService;

@RestController
public class UserController {
	
	@Autowired
	private IBusService iBusService;
	
	@Autowired
	private IFeedBackService iFeedBackService;

	@Autowired
	private RouteService routeService;
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/addFeedBack")
	
	public FeedBack addFeedBack(@RequestBody FeedBack feedback) {
		return iFeedBackService.addFeedBack(feedback);
	}

    @PutMapping("/updateFeedBack/{feedbackId}/{overallRating}")
 
    public FeedBack updateFeedBack(@PathVariable ("feedbackId") int feedbackId, @PathVariable("overallRating") int overallRating) {
	 return iFeedBackService.updateFeedBack(feedbackId,overallRating);
   }
 
    @GetMapping("/viewFeedBack/{feedbackId}")
    public FeedBack viewFeedBack(@PathVariable ("feedbackId") int feedbackId ) {
 
	return iFeedBackService.viewFeedBack(feedbackId);
   }

     
    @PostMapping("/addReservation/{reservation}")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		return reservationService.addReservation(reservation);
	}
	
	@PutMapping("/updateReservation/{reservationId}/{reservationType}")
	public Reservation updateReservation(@PathVariable ("reservationId") int reservationId,@PathVariable("reservationType") String reservationType) {
		return  reservationService.updateReservation(reservationId, reservationType);
	}
	
	@DeleteMapping("/deleteReservation/{reservationId}")
	public Reservation deleteReservation(@PathVariable ("reservationId") int reservationId) {
		return  reservationService.deleteReservation(reservationId);
	}
	
	@GetMapping("/viewReservation/{reservationId}")
	public Reservation viewReservation(@PathVariable("reservationId") int reservationId) {
		return  reservationService.viewReservation(reservationId);
	}
	
	
     
     
     

     

 }
