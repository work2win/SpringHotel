package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.User1Dao;
import com.springmvc.model.User1;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	//private static List<User1> users;
	@Autowired
	private User1Dao userDao;
	
	
	public void setUserDao(User1Dao userDao) {
		this.userDao = userDao;
	}


	public void register(User1 user){
		userDao.register(user);
		
	}
	
	
}
