package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.IUserRepository;
import com.cg.entity.User;

@Service

public class IUserService {
	
	@Autowired
	private IUserRepository iUserRepository;
	
	
	
	public User addUser(User user)
	{
		iUserRepository.save(user);
		return user;
		
	}
	public User updateUser( int userLoginId,String name) {
		User user=iUserRepository.findAll().get(userLoginId);
		user.setUserName(name);
		iUserRepository.deleteById(userLoginId);
		iUserRepository.save(user);
		return user;
		
		
	}
	public User deleteUser(int userLoginId) {
		User user=iUserRepository.findById(userLoginId).get();
		iUserRepository.deleteById(userLoginId);
		return user;
	}
	public User viewUser(int userId) {
		
		User user=iUserRepository.findById(userId).get();
		return user;
	}

	public List<User> viewAllUsers() {
		return iUserRepository.findAll();
	}
	
	
	

}
