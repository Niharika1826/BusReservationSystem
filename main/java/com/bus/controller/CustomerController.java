package com.bus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.AdminDto;
import com.bus.dto.UserDto;
import com.bus.serviceImplementation.AdminService;
import com.bus.serviceImplementation.UserService;

@RestController
public class CustomerController  {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addAdmin")
	public AdminDto addAdmin(@Valid @RequestBody  AdminDto admin) {
		return adminService.addAdmin(admin);
	}
	
	@PostMapping("/addUser")
	public UserDto addUser(@Valid @RequestBody  UserDto userDto) {
		return userService.addUser(userDto);
	}
   
	@GetMapping("/adminLogin/{adminUserName}/{adminPassword}")
	public String adminLogin(@PathVariable("adminUserName") String adminUserName,@PathVariable("adminPassword") String adminPassword) {
		return adminService.adminLogin(adminUserName, adminPassword);
	}
	 
	@GetMapping("/userLogin/{userName}/{password}")
	public String userLogin(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return userService.userLogin(userName, password);
	}
	
	
	
}
