package com.codejava.web;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codejava.models.Employee;
import com.codejava.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	public EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		
		employeeService = theEmployeeService;
	}
	
	@RequestMapping(value = "/employee/list",method = RequestMethod.GET)
	public List<Employee> getRoles() {
		
		return employeeService.findAll();
	}
	
    @RequestMapping(value = "/employee/delete/{id}",method = RequestMethod.DELETE)
	public void deleteById(@PathVariable long id) {
		
		Optional<Employee> employee =  employeeService.getEmployeeById(id);
		
		employeeService.deleteById(id);
		
	}
}
