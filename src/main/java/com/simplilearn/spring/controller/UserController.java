package com.simplilearn.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.spring.jpa.User;
import com.simplilearn.spring.service.UserService;

@RestController
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List<User> list() {

        logger.debug("Listing Users...");

        return this.userService.list();
    }

    @PostMapping("/users")
    void createUser(@RequestBody User user) {

        logger.debug("Creating User... {}",user);

        this.userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    User searchUser(@PathVariable int id) {

        logger.debug("Searching User... UserID: {}", id);

        return this.userService.findUser(id);
    }

    @GetMapping("/users/{id}/{username}")
    User searchUser(@PathVariable int id, @PathVariable String username) {

        logger.debug("Searching User... UserID: {}, Username: {}", id, username);

        return this.userService.findUser(new User(id,username));
    }

    @PutMapping("/users")
    void updateUser(@RequestBody User user) {

        logger.debug("Updating User... {}",user);

        this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {

        logger.debug("Deleting User... UserID: {}", id);

        this.userService.deleteUser(id);
    }

    @GetMapping("/search")
    String showSearch() {

        logger.debug("Showing Search...");

        return "search";
    }

}
