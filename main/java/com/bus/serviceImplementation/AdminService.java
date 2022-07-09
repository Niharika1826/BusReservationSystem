package com.bus.serviceImplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dto.AdminDto;
import com.bus.entity.Admin;
import com.bus.repository.AdminRepository;
import com.bus.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminDto addAdmin(AdminDto adminDto) {
		Admin admin =  new Admin();
		BeanUtils.copyProperties(adminDto, admin);
		adminRepository.save(admin);
		return adminDto;
	}
	
	public String adminLogin(String adminUserName,String adminPassword) {
		if(adminRepository.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword)!=null) {
			return "Login Successful";
		}
		return "Invalid Admin";
	}

	
}
