package com.bus.serviceImplementation;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.UserDto;
import com.bus.entity.User;
import com.bus.exceptions.UserNotFoundException;
import com.bus.repository.UserRepository;

@Service

public class UserService {
	
	
	@Autowired
	private UserRepository iUserRepository;
	
	
	
	public UserDto addUser(UserDto userDto){
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		iUserRepository.save(user);
		return userDto;
	}
	
	
	
	public UserDto updateUser(int userLoginId,String name) {
		
		if(!iUserRepository.existsById(userLoginId)) {
			throw new UserNotFoundException();
		}

		User user=new User();
		UserDto userDto=new UserDto();
		user = iUserRepository.findById(userLoginId).get();
		
		BeanUtils.copyProperties(user,userDto);
		userDto.setUserName(name);
		BeanUtils.copyProperties(userDto,user);
		iUserRepository.save(user);
		iUserRepository.flush();
		return userDto;
		
	}
	
	public UserDto deleteUser(int userLoginId) {
		
		if(!iUserRepository.existsById(userLoginId)) {
			throw new UserNotFoundException();
		}
		
		UserDto userDto=new UserDto();
		User user=new User();
		user = iUserRepository.findById(userLoginId).get();
		BeanUtils.copyProperties(user,userDto);
		iUserRepository.deleteById(userLoginId);
		return userDto;
	}
	
	public UserDto viewUser(int userLoginId) {
		
		if(!iUserRepository.existsById(userLoginId)) {
			throw new UserNotFoundException();
		}
		UserDto userDto=new UserDto();
		User user=new User();
	    user=iUserRepository.findById(userLoginId).get();
		BeanUtils.copyProperties(user,userDto);
		return userDto;
	}

	public List<UserDto> viewAllUsers() {
		
		List<UserDto>userDtoList=new ArrayList<>();
		List<User>userList=iUserRepository.findAll();
		UserDto userDto=new UserDto();
		for(User user:userList) {
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	public String userLogin(String userName, String password) {
		if(iUserRepository.findByUserNameAndPassword(userName, password)!=null) {
			return "Login Successful";
		}
		return "Invalid User";
	}
		
	
	
	

}
