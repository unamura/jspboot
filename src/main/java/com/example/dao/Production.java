package com.example.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Production {

	@Autowired
	@Qualifier("technicianRole")
	private Technician technician;
	
	@Inject
	@Qualifier("expertRole")
	private ExpertRole expert;
	
	@Autowired
	private MovieRole actorRole;
	
	@Autowired
	private List<MovieRole> listRole;
	
	public String getTechnician() {
		return technician.roleDescription() + ", is in the movie";
	}
	
	public String getExpert() {
		return " Injection of " + expert.roleDescription();
	}
	
	public String getActorRole() {
		return "Actor role, from interface type: " + actorRole.roleDescription();
	}
	
	public String getListRole() {
		//String result = "";
		//for(MovieRole role : listRole) {
			//result += "\n" + role.roleDescription();
		//}
		return "ListRole: " + listRole;
	}
}
