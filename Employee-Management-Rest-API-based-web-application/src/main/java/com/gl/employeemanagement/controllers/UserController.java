package com.gl.employeemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.entity.User;
import com.gl.employeemanagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		userServiceImpl.addUser(user);
		return "User added to DB.";
	}
}
