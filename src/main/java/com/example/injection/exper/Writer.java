package com.example.injection.exper;

public class Writer implements Expert {
	
	private String name;
	
	public Writer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String currentOccupation() {
		return name + " is now a writer";
	}

}
