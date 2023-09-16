package com.gl.employeemanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.employeemanagement.serviceImpl.RoleServiceImpl;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	RoleServiceImpl roleServiceImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/role/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("ADMIN")
			.antMatchers("/employee/addEmployee").hasRole("ADMIN")
			.antMatchers("/employee/updateEmployee").hasRole("ADMIN")
			.antMatchers("/employee/deleteEmployee**", "/employee/deleteEmployee/**").hasRole("ADMIN")
			.antMatchers("/employee/getAllEmployees").authenticated()
			.antMatchers("/employee/getEmployeeById**","/employee/getEmployeeById/**").authenticated()
			.antMatchers("/employee/getEmployeeByFirstname**","/employee/getEmployeeByFirstname/**").authenticated()
			.antMatchers("/employee/getAllEmployeesCustomSorted**","/employee/getAllEmployeesCustomSorted/**").authenticated()
			.and().httpBasic().and().formLogin();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
