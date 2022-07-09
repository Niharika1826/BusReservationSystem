package com.bus.service;

import java.util.List;

import com.bus.dto.FeedBackDto;

public interface IFeedBackService {
 
	public FeedBackDto addFeedBack(FeedBackDto feedBackDto);
	public FeedBackDto updateFeedBack(int feedbackId, int overallRating);
	public FeedBackDto viewFeedBack(int feedbackId);
	public List<FeedBackDto> viewAllFeedBack();
	
}
