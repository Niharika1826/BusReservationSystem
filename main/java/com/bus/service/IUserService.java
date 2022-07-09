package com.bus.service;

import java.util.List;

import com.bus.dto.UserDto;

public interface IUserService {

	public UserDto addUser(UserDto userDto);
	public UserDto updateUser(int userLoginId,String name);
	public UserDto deleteUser(int userLoginId);
	public UserDto viewUser(int userLoginId);
	public List<UserDto> viewAllUsers();
	public String userLogin(String userName, String password);
	
}
