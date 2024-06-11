package com.example.demo.rs.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.rs.api.WelcomeService;
import com.example.demo.service.UserService;

@Component
public class WelcomeServiceImpl implements WelcomeService {
	
	@Autowired
	private UserService userService;

	@Override
	public String welcome(String name) {
		return "Welcome " + name + " to CXF restful webserice!!! " + userService.getUsername();
	}

}
