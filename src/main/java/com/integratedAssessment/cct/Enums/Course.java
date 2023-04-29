package com.integratedAssessment.cct.Enums;

public enum Course {
	
	BUSINESS("Business"),
	MARKETING("Marketing"),
	COMPUTINGSCIENCE("Computing Scince");
	
	private String course;
	
	private Course(String course) {
	this.course = course;	
	}
}