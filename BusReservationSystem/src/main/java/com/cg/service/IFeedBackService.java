package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.FeedBack;
import com.cg.repository.IFeedBackRepository;


@Service
public class IFeedBackService  {
	
	@Autowired
    private IFeedBackRepository iFeedBackRepository;
	


	public FeedBack addFeedBack(FeedBack feedback) {
		iFeedBackRepository.save(feedback);
		return feedback;
	}

	
	public FeedBack updateFeedBack(int feedbackId, int overallRating) {
		
		FeedBack feedback=iFeedBackRepository.findById(feedbackId).get();
		feedback.setOverallRating(overallRating);
		iFeedBackRepository.deleteById(feedbackId);
		iFeedBackRepository.save(feedback);
			
		return feedback;
	}

	
	public FeedBack viewFeedBack(int feedbackId) {
		FeedBack feedback= iFeedBackRepository.findById(feedbackId).get();
		
				return feedback;
	}

	
	public List<FeedBack> viewAllFeedBack() {
		
		return iFeedBackRepository.findAll();
	}

}
