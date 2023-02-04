package com.gl.employeemanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.gl.employeemanagement.entity.Role;
import com.gl.employeemanagement.entity.User;
import com.gl.employeemanagement.repository.RoleRepository;
import com.gl.employeemanagement.repository.UserRepository;

@Configuration
public class BootStrapAppData {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void insertAllData(ApplicationReadyEvent event) {
		User test1 = new User("test1", passwordEncoder.encode("welcome"));
		User test2 = new User("test2", passwordEncoder.encode("welcome"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		roleRepository.saveAndFlush(userRole);
		roleRepository.saveAndFlush(adminRole);

		test1.addRole(adminRole);
		test1.addRole(userRole);
		test2.addRole(userRole);

		userRepository.saveAndFlush(test1);
		userRepository.saveAndFlush(test2);

	}
}
