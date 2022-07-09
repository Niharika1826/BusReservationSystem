package com.bus.serviceImplementation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.ReservationDto;
import com.bus.entity.Reservation;
import com.bus.exceptions.ReservationNotFoundException;
import com.bus.repository.ReservationRepository;

@Service
public class ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;

	public ReservationDto addReservation(ReservationDto reservationDto) {
		Reservation reservation=new Reservation();
		BeanUtils.copyProperties(reservationDto, reservation);
		 reservationRepository.save(reservation);
		return reservationDto;
	}

	public ReservationDto updateReservation(int reservationId,String reservationType) {
		
		if(!reservationRepository.existsById(reservationId)) {
			throw new ReservationNotFoundException();
		}
		
		Reservation reservation=new Reservation();
		ReservationDto reservationDto=new ReservationDto();
		BeanUtils.copyProperties(reservationRepository.findById(reservationId).get(), reservationDto);
		
		reservationDto.setReservationType(reservationType);
		
		BeanUtils.copyProperties(reservationDto, reservation);
		reservationRepository.save(reservation);
		reservationRepository.flush();
		
		return reservationDto;
	}

	
	public ReservationDto deleteReservation(int reservationId) {
		if(!reservationRepository.existsById(reservationId)) {
			throw new ReservationNotFoundException();
		}
		ReservationDto reservationDto=new ReservationDto();
		Reservation reservation=new Reservation();
		reservation = reservationRepository.findById(reservationId).get();
		       BeanUtils.copyProperties(reservation, reservationDto);
		       reservationRepository.deleteById(reservationId);
		       return reservationDto;
			}


	public ReservationDto viewReservation(int reservationId) {
		if(!reservationRepository.existsById(reservationId)) {
			throw new ReservationNotFoundException();
		}
		ReservationDto reservationDto=new ReservationDto();
		Reservation reservation=new Reservation();
		
		reservation=reservationRepository.findById(reservationId).get();
		BeanUtils.copyProperties(reservation, reservationDto);
		
		return reservationDto;
	}

	public List<ReservationDto> viewAllReservation() {
		List<ReservationDto> reservationDtoList=new ArrayList<>();
		List<Reservation> reservationList=reservationRepository.findAll();
		ReservationDto reservationDto=new ReservationDto();
		for(Reservation reservation:reservationList) {
			BeanUtils.copyProperties(reservation, reservationDto);
			reservationDtoList.add(reservationDto);
		}
		return reservationDtoList;
	
	}

	public List<ReservationDto> getAllReservation(LocalDate date) {
		
		List<Reservation> reservationList = reservationRepository.findAllByReservationDate(date);
		List<ReservationDto> reservationDtoList = new ArrayList<>();
		
		ReservationDto reservationDto = new ReservationDto();
		
		for(Reservation reservation : reservationList) {
			BeanUtils.copyProperties(reservation, reservationDto);
			reservationDtoList.add(reservationDto);
		}
		
		return reservationDtoList;
				
		
	}
	
}