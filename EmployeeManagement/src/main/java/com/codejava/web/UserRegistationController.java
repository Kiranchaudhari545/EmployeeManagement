package com.codejava.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.codejava.service.UserService;
import com.codejava.models.User;
import com.codejava.web.dto.UserRegistrationDto;

@Controller
public class UserRegistationController {
	
	private UserService userService;
    
	public UserRegistationController(UserService userService) {
		super();
		this.userService = userService;
	}
		
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<User> getAllEmployees(){
		return userService.getAllEmployees();
	}
	
	@ModelAttribute
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
	    UserRegistrationDto userDto = new UserRegistrationDto();
	    model.addAttribute("user", userDto);
	    return "registration";
	}
    
	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
