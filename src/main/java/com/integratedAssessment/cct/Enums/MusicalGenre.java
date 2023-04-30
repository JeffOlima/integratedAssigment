package com.integratedAssessment.cct.Enums;

public enum MusicalGenre {
	
	ROCK("Rock"),
	RAP("Rap"),
	POP("Pop"),
	CLASSIC("Classic"),
	REGGAE("Reggae");
	
	private String musicalGenre;
	
	private MusicalGenre(String musicalGenre) {
	this.musicalGenre = musicalGenre;	
	}
}