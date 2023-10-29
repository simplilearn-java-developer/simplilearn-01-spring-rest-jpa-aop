package com.simplilearn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplilearn.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
    @GetMapping("/")
    String showIndex() {

        return "index";
    }
    
    @GetMapping("/list")
    String list() {
    	
    	return "index";
    }
}
