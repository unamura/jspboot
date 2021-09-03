package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("oneActor")
public class Movie {
	
	@Autowired
	@Qualifier("actorRole")
	private Actor actor;
	
	@Autowired
	@Qualifier("hybridRole")
	private Actor hybrid;
	
	public Movie() {
		
	}
	
	public Movie(Actor actor) {
		this.actor = actor;
	}
	
	public String getHybridRole() {
		return "Movie, and " + hybrid.roleDescription();
	}
	
	@Override
	public String toString() {
		return "Movie[" + actor.roleDescription() + "]";
	}

}
