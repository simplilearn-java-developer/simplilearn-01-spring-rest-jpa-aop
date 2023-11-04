package com.simplilearn.spring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/create")
    String showCreate(User user) {

        logger.debug("Showing Create...");

        return "create";
    }

    @PostMapping("/create")
    String createUser(User user, BindingResult result) {

        logger.debug("Creating User... {}",user);

        this.validateUsername(user, result);
        
        if (result.hasErrors()) {
        	return "create";
        }
        
        this.userService.createUser(user);

        return "redirect:/list";
    }
    
    void validateUsername(User user, BindingResult result) {
    	
//    	if ( this.userService.findUser(user) != null) {
        if ( Optional.ofNullable(this.userService.findUser(user)).isPresent() ) {
        	
    		result.addError(new FieldError("user","username", user.getUsername(),
    				                          false,null, null,"* Username already taken."));
    	}
    }
}
