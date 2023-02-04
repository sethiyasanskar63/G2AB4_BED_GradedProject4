package com.gl.employeemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.entity.Employee;
import com.gl.employeemanagement.repository.EmployeeRepository;
import com.gl.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted employee id - " + id;
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String fname) {
		return employeeRepository.findEmployeesByFirstName(fname);
	}

	@Override
	public List<Employee> getAllEmployeesCustomSorted(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}
}
