package com.example.jspboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dao.Actor;
import com.example.dao.ExpertRole;
import com.example.dao.HybridRole;
import com.example.dao.Movie;
import com.example.dao.Production;
import com.example.dao.Technician;

@Configuration
public class SystemConfig {

	@Bean
	@Qualifier("hybridRole")
	public Actor getHybridActor() {
		return new HybridRole("Adam Driver");
	}
	
	@Bean
	@Qualifier("actorRole")
	public Actor getActor() {
		return new Actor("Adam Driver");
	}
	
	@Bean
	@Qualifier("technicianRole")
	public Technician getTechnician() {
		return new Technician("Ludwig Gorannson");
	}
	
	@Bean
	@Qualifier("expertRole")
	public Technician getExpertTech() {
		return new ExpertRole("John Lasseter");
	}
	
	@Bean
	public Production getProduction() {
		return new Production();
	}

	@Bean
	public Movie getMovie() {
		return new Movie();
	}
}
