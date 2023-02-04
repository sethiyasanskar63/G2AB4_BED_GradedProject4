package com.gl.employeemanagement.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.entity.User;
import com.gl.employeemanagement.repository.UserRepository;

@Service
@Primary
public class DomainUserServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public DomainUserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findUserByUsername(username);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			return new DomainUserDetails(user);
		} else {
			throw new UsernameNotFoundException("Invalid Username: " + username);
		}

	}

}
