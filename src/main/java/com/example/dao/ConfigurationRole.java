package com.example.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationRole {

	@Bean
	public MovieRole getActor() {
		return new Actor("Nicholas Cage");
	}
}
