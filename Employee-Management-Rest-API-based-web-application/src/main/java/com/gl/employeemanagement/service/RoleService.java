package com.gl.employeemanagement.service;

import com.gl.employeemanagement.entity.Role;

public interface RoleService {

	Role addRole(Role role);

	String[] getAllRoles();

}