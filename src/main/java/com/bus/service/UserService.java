package com.bus.service;

import org.springframework.stereotype.Service;

import com.bus.model.User;


public interface UserService {

	public User validateUser(String userid, String password) ;

	public User addUser(User user);
	
	public User findById(Long id);

	public int changePasswordDtl(Long userId, String newPassword);
}
