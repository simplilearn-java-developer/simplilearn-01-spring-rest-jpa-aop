package com.simplilearn.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.spring.bean.User;
import com.simplilearn.spring.service.UserService;

@Controller
public class UserController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
    @GetMapping("/")
    String showIndex() {

    	logger.debug("Showing Index...");
    	
        return "index";
    }
    
    @GetMapping("/list")
    ModelAndView list() {
    	
    	logger.debug("Listing Users...");

    	List<User> users = this.userService.list();
    	
    	return new ModelAndView("list","users",users);
    }
}
