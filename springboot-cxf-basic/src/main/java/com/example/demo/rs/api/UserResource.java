package com.example.demo.rs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Service
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserInfo() {
		return userService.getUsername();
	}
}
