package com.codejava.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.codejava.models.User;
import com.codejava.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
    User save(UserRegistrationDto registrationDto);
	
	public List<User> getAllEmployees();

}
