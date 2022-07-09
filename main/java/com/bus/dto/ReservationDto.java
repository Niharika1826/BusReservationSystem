package com.bus.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.bus.entity.Bus;
import com.bus.entity.User;



@Component
public class ReservationDto {

	 private int reservationId;
	 private String reservationStatus;
	 @NotNull(message = "reservation type should be mentioned")
	 private String reservationType;
	 private LocalDate reservationDate;
	 private LocalTime reservationTime;
	 private String destination;
	 private String source;
	 private Bus bus;
	 private User user;
	 
	 public ReservationDto() {}
	 
	public ReservationDto(int reservationId, String reservationStatus, String reservationType, LocalDate reservationDate,
			LocalTime reservationTime, String source, String destination, Bus bus,User user) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.destination = destination;
		this.bus = bus;
		this.source = source;
		this.user = user;
	}
	
	 public int getReservationId() {
		return reservationId;
	}
	 public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	 public String getReservationStatus() {
		return reservationStatus;
	}
	 public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	 public String getReservationType() {
		return reservationType;
	}
	 public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	 public LocalDate getReservationDate() {
		return reservationDate;
	}
	 public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	 public LocalTime getReservationTime() {
		return reservationTime;
	}
	 public void setReservationTime(LocalTime reservationTime) {
	 	this.reservationTime = reservationTime;
	}
	 public String getSource() {
		return source;
	}
	 public void setSource(String source) {
		this.source = source;
	}
	 public String getDestination() {
		return destination;
	}
	 public void setDestination(String destination) {
		this.destination = destination;
	}
	 public Bus getBus() {
		return bus;
	}
	 public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
	 
	 
}
