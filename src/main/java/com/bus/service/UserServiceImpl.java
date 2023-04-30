package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dao.UserDao;
import com.bus.model.Bus;
import com.bus.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public User validateUser(String userid, String password) {
//        return userid.equalsIgnoreCase("admin@busbooking.com")
//                && password.equalsIgnoreCase("admin@123");
		
		User user=userDao.findByEmail(userid);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
	
				return user;
				
			}else {
				return null;
			}
		}else {
			return null;
		}
    }

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User userDtl=userDao.addUserDtl(user);
		return userDtl;
	}
	
	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public int changePasswordDtl(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		return userDao.changePasswordDtl(userId, newPassword);
	}
}
