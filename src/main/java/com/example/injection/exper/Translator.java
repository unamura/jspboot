package com.example.injection.exper;

//@Component
public class Translator implements Expert {
	
	private String name;
	
	public Translator() {}
	
	
	public Translator(String name) {
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
		return getName() + " is a good translator";
	}

}
