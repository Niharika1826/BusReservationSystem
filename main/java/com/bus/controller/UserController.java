package com.bus.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.FeedBackDto;
import com.bus.dto.ReservationDto;
import com.bus.dto.UserDto;
import com.bus.serviceImplementation.FeedBackService;
import com.bus.serviceImplementation.ReservationService;
import com.bus.serviceImplementation.UserService;


@RestController
public class UserController {
	
	@Autowired
	private FeedBackService feedBackService;

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@PutMapping("/updateUser/{userId}/{userName}")
	public UserDto updateUser(@PathVariable("userId")int userId,@PathVariable("userName")String name) {
     return userService.updateUser(userId,name);
	}
	
	@DeleteMapping("/deleteUser/{userLoginId}")
	public UserDto deleteUser(@PathVariable("userLoginId")int userLoginId) {
		return userService.deleteUser(userLoginId);
	}
	
    @PostMapping("/addFeedBack")
	
	public FeedBackDto addFeedBack(@RequestBody @Valid FeedBackDto feedBackDto) {
		return feedBackService.addFeedBack(feedBackDto);
	}

    @PutMapping("/updateFeedBack/{feedbackId}/{overallRating}")
 
    public FeedBackDto updateFeedBack(@PathVariable ("feedbackId") int feedbackId, @PathVariable("overallRating") int overallRating) {
	 return feedBackService.updateFeedBack(feedbackId,overallRating);
   }
 
    @GetMapping("/viewFeedBack/{feedbackId}")
    public FeedBackDto viewFeedBack(@PathVariable ("feedbackId") int feedbackId ) {
 
	return feedBackService.viewFeedBack(feedbackId);
   }

     
    @PostMapping("/addReservation")
	public ReservationDto addReservation(@Valid @RequestBody  ReservationDto reservationDto) {
		return reservationService.addReservation(reservationDto);
	}
	
    @PutMapping("/updateReservation/{reservationId}/{reservationType}")
	public ReservationDto updateReservation(@PathVariable ("reservationId") int reservationId,@PathVariable("reservationType") String reservationType) {
		return  reservationService.updateReservation(reservationId, reservationType);
	}
    
	@DeleteMapping("/deleteReservation/{reservationId}")
	
	public ReservationDto deleteReservation(@PathVariable ("reservationId") int reservationId) {
		return  reservationService.deleteReservation(reservationId);
	}
	
	
	@GetMapping("/viewReservationById/{reservationId}")
	public ReservationDto viewReservation(@PathVariable("reservationId") int reservationId) {
		return  reservationService.viewReservation(reservationId);
	}
	
	
	
		
 }
