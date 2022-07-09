package com.bus.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.FeedBackDto;
import com.bus.entity.FeedBack;
import com.bus.exceptions.FeedBackNotFoundException;
import com.bus.repository.FeedBackRepository;
import com.bus.service.IFeedBackService;


@Service
public class FeedBackService implements IFeedBackService {
	
	@Autowired
    private FeedBackRepository iFeedBackRepository;
	


	public FeedBackDto addFeedBack(FeedBackDto feedBackDto) {
		FeedBack feedBack = new FeedBack();
		BeanUtils.copyProperties(feedBackDto, feedBack);
		iFeedBackRepository.save(feedBack);
		return feedBackDto;
	}

	
	public FeedBackDto updateFeedBack(int feedbackId, int overallRating) {
		
		if(!iFeedBackRepository.existsById(feedbackId)) {
			throw new FeedBackNotFoundException();
		}
		FeedBackDto feedbackDto = new FeedBackDto();
		FeedBack feedback=iFeedBackRepository.findById(feedbackId).get();
		feedback.setOverallRating(overallRating);
		iFeedBackRepository.deleteById(feedbackId);
		iFeedBackRepository.save(feedback);
		BeanUtils.copyProperties(feedback, feedbackDto);
			
		return feedbackDto;
	}

	
	public FeedBackDto viewFeedBack(int feedbackId) {
		if(!iFeedBackRepository.existsById(feedbackId)) {
			throw new FeedBackNotFoundException();
		}
		FeedBackDto feedbackDto = new FeedBackDto();
		FeedBack feedback= iFeedBackRepository.findById(feedbackId).get();
		
		BeanUtils.copyProperties(feedback, feedbackDto);
		
				return feedbackDto;
	}

	
	public List<FeedBackDto> viewAllFeedBack() {
		FeedBackDto feedBackDto = new FeedBackDto();
		List<FeedBack> feedBackList = iFeedBackRepository.findAll();
		List<FeedBackDto> feedBackDtoList = new ArrayList<>();
		for(FeedBack feedBack : feedBackList) {
			BeanUtils.copyProperties(feedBack, feedBackDto);
			feedBackDtoList.add(feedBackDto);
		}
		
		return feedBackDtoList;
	}

}
