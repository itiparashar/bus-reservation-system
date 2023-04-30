package com.bus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Bus;
import com.bus.model.User;

public interface UserDao {
    public User findByEmail(String email);

	public User addUserDtl(User user);
	
	public User findById(Long id);

	public int changePasswordDtl(Long userId, String newPassword);
    
}