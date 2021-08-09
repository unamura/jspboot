package com.example.injection;

import org.springframework.stereotype.Component;

@Component
public class Journalist {

	private String name;

	public Journalist() {}
	
	public Journalist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "The journalist name is: " + getName();
	}
}
