package com.gl.employeemanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.entity.User;
import com.gl.employeemanagement.repository.UserRepository;
import com.gl.employeemanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder1;

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder1.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

}
