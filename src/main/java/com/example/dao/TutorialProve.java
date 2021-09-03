package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class TutorialProve {
	public static void main(String[] args) {
		
		Actor myActor = new Actor("Charles Dance");
		
		Movie myMovie = new Movie(myActor);
		
		MovieRole actorMovieRole = new Actor("Vincent Price");
		
		MovieRole expertMovieRole = new ExpertRole("Dave Filoni");
		
		Production prod = new Production();
		
		System.out.println(myMovie.toString());
		
		System.out.println(myActor.roleDescription());
		
		System.out.println("Interface actor: " + actorMovieRole.roleDescription());
		
		System.out.println("Interface expert: " + expertMovieRole.roleDescription());
		
		System.out.println("Prod tech: " + prod.getActorRole());
	}
}
