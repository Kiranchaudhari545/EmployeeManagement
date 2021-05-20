package com.codejava.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codejava.models.Employee;
import com.codejava.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
    	
    	employeeService.save(theEmployee);
    	
    	return "redirect:/employee/home";
    }
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employeeForm";
	}
	
	@GetMapping("/home")
	public String getHomePage() {
		
		return "index";
	}

}
