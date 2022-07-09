package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.dto.ReservationDto;

public interface IReservationService {

	public ReservationDto addReservation(ReservationDto reservationDto);
	public ReservationDto updateReservation(int reservationId,String reservationType);
	public ReservationDto deleteReservation(int reservationId);
	public ReservationDto viewReservation(int reservationId);
	public List<ReservationDto> viewAllReservation();
	public List<ReservationDto> getAllReservation(LocalDate date) ;
	
}
