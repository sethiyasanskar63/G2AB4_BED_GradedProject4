package com.gl.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.employeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE FIRSTNAME ILIKE %?1%")
	List<Employee> findEmployeesByFirstName(String fName);
}
