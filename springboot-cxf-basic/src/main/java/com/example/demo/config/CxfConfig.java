package com.example.demo.config;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.rs.api.UserResource;
import com.example.demo.rs.api.WelcomeService;

@Configuration
public class CxfConfig {

	@Autowired
    private Bus bus;
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private UserResource userResource;
	
	@Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(welcomeService, userResource));
        endpoint.setAddress("/");
        return endpoint.create();
    }
}
