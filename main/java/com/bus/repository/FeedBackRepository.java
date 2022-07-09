package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack,Integer> {
	

}
