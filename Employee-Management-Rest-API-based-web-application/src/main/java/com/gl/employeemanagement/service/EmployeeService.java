package com.gl.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.employeemanagement.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee saveEmployee(Employee employee);

	String deleteEmployeeById(Long id);

	List<Employee> getEmployeesByFirstName(String fname);

	List<Employee> getAllEmployeesCustomSorted(Direction direction);

}