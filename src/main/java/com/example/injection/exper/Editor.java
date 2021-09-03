package com.example.injection.exper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Editor implements Expert {

	private Writer writer;

	@Autowired
	public Editor(Writer writer) {
		this.writer = writer;
	}

	@Override
	public String currentOccupation() {
		return writer.getName() + " has now an editor";
	}
}
