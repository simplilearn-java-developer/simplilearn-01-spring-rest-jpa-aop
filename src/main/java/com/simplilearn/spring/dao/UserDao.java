package com.simplilearn.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
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

    public void createUser(User user) {

        String sql = "INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BIRTH, STATUS) "
                + "VALUES(?,?,?,?,?,?)";

        this.jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),
                    user.getBirth(), "A");
    }

    public User findUser(User user) {

        String sql = "SELECT * FROM USER WHERE ID_USER!=? AND UPPER(USERNAME) = UPPER(?)";

        return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new UserMapper(), user.getIdUser(), user.getUsername()));
    }

}
