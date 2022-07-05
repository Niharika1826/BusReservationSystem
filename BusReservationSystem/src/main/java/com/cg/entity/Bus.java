package com.cg.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int busId;
	
	@Column
	private String busName;
	@Column
	private String driverName;
	@Column
	private String busType;
	@Column
	private String routeFrom;
	@Column
	private String routeTo;
	@Column
    private LocalTime arrivalTime;
	@Column
	private LocalTime departureTime;
	@Column
	private int seats;
	@Column
	private int availableSeats;

	
	public Bus() {}


	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, int seats, int availableSeats) {
		
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.availableSeats = availableSeats;
	}


	public int getBusId() {
		return busId;
	}


	public void setBusId(int busId) {
		this.busId = busId;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}


	public String getRouteFrom() {
		return routeFrom;
	}


	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}


	public String getRouteTo() {
		return routeTo;
	}


	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}


	public LocalTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public LocalTime getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", driverName=" + driverName + ", busType=" + busType
				+ ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", seats=" + seats + ", availableSeats=" + availableSeats + "]";
	}
	
	
}
