package com.example.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Program {

	@Autowired
	private Journalist journalist;
	
	public String getJournalist(String name) {
		journalist.setName(name);
		return "This is a program: " + journalist.toString();
	}
}
