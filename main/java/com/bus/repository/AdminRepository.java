package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,Integer> {

	  public Admin findByAdminUserNameAndAdminPassword(String adminUserName, String adminPassword);
}
