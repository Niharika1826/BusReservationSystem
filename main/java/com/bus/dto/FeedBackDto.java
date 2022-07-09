package com.bus.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

import com.bus.entity.Bus;
import com.bus.entity.User;

@Component
public class FeedBackDto {
	
	private int feedBackId;
	@Min(0)
	@Max(5)
    private int drivingRating;
	@Min(0)
	@Max(5)
    private int serviceRating;
	@Min(0)
	@Max(10)
	private int overallRating;
	private String comments;
	private LocalDate feedBackDate;
	private User user;
	private Bus bus;
	
	public FeedBackDto() {}
	
	public FeedBackDto(int feedBackId, int drivingRating, int serviceRating, int overallRating, String comments,
			LocalDate feedBackDate, User user, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.drivingRating = drivingRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedBackDate = feedBackDate;
		this.user = user;
		this.bus = bus;
	}
	
	
	public int getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}
	public int getDrivingRating() {
		return drivingRating;
	}
	public void setDrivingRating(int drivingRating) {
		this.drivingRating = drivingRating;
	}
	public int getServiceRating() {
		return serviceRating;
	}
	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}
	public int getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDate getFeedBackDate() {
		return feedBackDate;
	}
	public void setFeedBackDate(LocalDate feedBackDate) {
		this.feedBackDate = feedBackDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
	

}
