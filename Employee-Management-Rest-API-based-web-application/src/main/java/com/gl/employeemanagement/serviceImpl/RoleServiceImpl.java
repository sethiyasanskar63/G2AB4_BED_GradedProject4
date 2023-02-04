package com.gl.employeemanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.entity.Role;
import com.gl.employeemanagement.repository.RoleRepository;
import com.gl.employeemanagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	public String[] getAllRoles() {
		return (String[]) roleRepository.findAll().toArray();
	}
}
