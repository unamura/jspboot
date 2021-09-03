package com.example.dao;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("actorRole")
public class Actor implements MovieRole {
	
	private String name;

	public Actor() {
		
	}
	
	public Actor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String roleDescription() {
		return (getName() + " is an actor");
	}
	

}
