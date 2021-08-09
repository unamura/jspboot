package com.example.springtest;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Production {

	@Autowired
	@Qualifier("technicianRole")
	private Technician technician;
	
	@Inject
	@Qualifier("expertRole")
	private ExpertRole expert;
	
	public String getTechnician() {
		return technician.roleDescription() + ", is in the movie";
	}
	
	public String getExpert() {
		return " Injection of " + expert.roleDescription();
	}
}
