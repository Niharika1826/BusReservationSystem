package com.bus.service;

import com.bus.dto.AdminDto;

public interface IAdminService {
	
	public AdminDto addAdmin(AdminDto adminDto);
	public String adminLogin(String adminUserName,String adminPassword);

}
