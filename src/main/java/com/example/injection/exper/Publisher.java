package com.example.injection.exper;

public class Publisher {
	
	private String publisherName;
	
	public Publisher() {}
	
	public Publisher(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
