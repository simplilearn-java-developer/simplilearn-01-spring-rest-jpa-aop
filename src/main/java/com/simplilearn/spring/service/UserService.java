package com.simplilearn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.spring.bean.User;
import com.simplilearn.spring.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<User> list() {
		
		/*
		 * Add some Business Logic to process the list.
		 */
		
		return this.userDao.list();
	}
}
