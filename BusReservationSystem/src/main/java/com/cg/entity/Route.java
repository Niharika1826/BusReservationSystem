package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer routeId;
	@Column
	private String routeFrom;
	@Column
	private String routeTo;
	@Column
	private Integer distance;
	@OneToMany(targetEntity = Bus.class, cascade = CascadeType.ALL)
	@JoinTable(name = "busRoute")
	private List<Bus> bus;
	
	public Route() {}
	public Route(Integer routeId, String routeFrom, String routeTo, Integer distance) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
		//this.bus = bus;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
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

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", distance="
				+ distance + ", bus=" + bus + "]";
	}

	    
	}
