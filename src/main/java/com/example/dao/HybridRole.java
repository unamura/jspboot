package com.example.dao;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("hybridRole")
public class HybridRole extends Actor {

	public HybridRole(String name) {
		super(name);
	}

	@Override
	public String roleDescription() {
		return (super.getName() + " is an hybrid-actor");
	}
}
