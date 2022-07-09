package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
       public User findByUserNameAndPassword(String userName,String password);

}
