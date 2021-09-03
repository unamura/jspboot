package com.example.dao;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("technicianRole")
public class Technician implements MovieRole {

	private String name;

	public Technician() {

	}

	public Technician(String name) {
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
		return getName() + " : technician";
	}
	
	@Override
	public String toString() {
		return "The technician name is " + getName();
	}

}
