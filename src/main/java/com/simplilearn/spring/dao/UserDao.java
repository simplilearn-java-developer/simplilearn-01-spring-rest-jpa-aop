package com.simplilearn.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.simplilearn.spring.bean.User;
import com.simplilearn.spring.dao.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<User> list() {
		
		String sql = "SELECT * FROM USER";
		
		return this.jdbcTemplate.query(sql, new UserMapper());
	}

}
