package com.example.springtest;

public class TutorialProve {
	public static void main(String[] args) {
		Actor myActor = new Actor("Charles Dance");
		
		Movie myMovie = new Movie(myActor);
		
		System.out.println(myMovie.toString());
		
		System.out.println(myActor.roleDescription());
	}
}
