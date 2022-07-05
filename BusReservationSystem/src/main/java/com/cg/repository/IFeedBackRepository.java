package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.entity.FeedBack;

public interface IFeedBackRepository extends JpaRepository<FeedBack,Integer> {
	
	//public FeedBack addFeedBack(FeedBack feedback);
	//public FeedBack updateFeedBack(FeedBack feedback);
	//public FeedBack viewFeedBack(int feedbackId);
	//public List<FeedBack> viewAllFeedBack();
  

}
