package com.qa.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//this class must be part of the same Spring config package for it to be recognised on boot
@Configuration //notifies the spring framework the config file where to look initially
public class AppConfig {

	@Bean
	public String tdlGreeting() {
		return "Welcome to TDL!";
	}
	
	@Bean
	public String serverInfo() {
		return "http://localhost:8080/swagger-ui/index.html";
	}

	@Bean
	public String serverStart() { 
		return LocalTime.now().toString();
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	//
}
