package com.example.jspboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springtest.Actor;
import com.example.springtest.ExpertRole;
import com.example.springtest.HybridRole;
import com.example.springtest.Movie;
import com.example.springtest.Production;
import com.example.springtest.Technician;

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
