package com.gl.employeemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.entity.Role;
import com.gl.employeemanagement.serviceImpl.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;

	@PostMapping("/addRole")
	public String addRole(@RequestBody Role role) {
		roleServiceImpl.addRole(role);
		return "Role added.";
	}

}
