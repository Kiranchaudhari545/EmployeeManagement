package com.codejava.service;

import java.util.List;
import java.util.Optional;

import com.codejava.models.Employee;

public interface EmployeeService {

	public void save(Employee theEmployee);

	public List<Employee> findAll();
	
	public Optional<Employee> getEmployeeById(long id);
	
	public void deleteById(long id);

}
