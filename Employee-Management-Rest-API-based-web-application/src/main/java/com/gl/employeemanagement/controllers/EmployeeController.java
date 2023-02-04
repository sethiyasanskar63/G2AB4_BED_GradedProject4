package com.gl.employeemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.entity.Employee;
import com.gl.employeemanagement.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeServiceImpl.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@GetMapping("/getEmployeeByFirstname/{fname}")
	public List<Employee> searchEmployeeByFirstName(@PathVariable("fname") String fname) {
		return employeeServiceImpl.getEmployeesByFirstName(fname);
	}

	@GetMapping("/getAllEmployeesCustomSorted")
	public List<Employee> getAllEmployeesCustomSorted(String order) {
		Direction direction = Direction.ASC;
		if (order.equalsIgnoreCase("desc")) {
			direction = Direction.DESC;
		}
		return employeeServiceImpl.getAllEmployeesCustomSorted(direction);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.saveEmployee(employee);
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		return "Employee saved.";
	}

	@DeleteMapping("/deleteEmployeeId/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		return employeeServiceImpl.deleteEmployeeById(id);
	}

}
