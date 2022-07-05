package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class FeedBack  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedBackId;
	@Column
	private int driverRating;
	@Column
	private int serviceRating;
	@Column
	private int overallRating;
	@Column
	private String comments;
	@Column
	private LocalDate feedbackdate;
	//private User users;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "userbus")
	private Bus bus;
	
	public FeedBack() {}
	
	public FeedBack(int feedBackId, int driverRating, int serviceRating, int overallRating, String comments,
			LocalDate feedbackdate, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedbackdate = feedbackdate;
		//this.users = users;
		this.bus = bus;
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public int getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
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

	public LocalDate getFeedbackdate() {
		return feedbackdate;
	}

	public void setFeedbackdate(LocalDate feedbackdate) {
		this.feedbackdate = feedbackdate;
	}

//	public User getUsers() {
//		return users;
//	}
//
//	public void setUsers(User users) {
//		this.users = users;
//	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", driverRating=" + driverRating + ", serviceRating="
				+ serviceRating + ", overallRating=" + overallRating + ", comments=" + comments + ", feedbackdate="
				+ feedbackdate +" ,bus"+bus+ "]";
	}
	
	
	

}

