package com.example.springtest;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("expertRole")
public class ExpertRole extends Technician {

	public ExpertRole(String name) {
		super(name);
	}

	@Override
	public String roleDescription() {
		return (super.getName() + " is an expert ");
	}
}
