package com.integratedAssessment.cct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.integratedAssessment.cct.Enums.Course;

import javax.persistence.Column;

@Entity
public class Student {
		
		@Id
		private String id;
		@Column(name = "name")
		private String name;
		@Column(name = "surname")
		private String surname;
		@Column(name = "studentNumber")
		private String studentNumber;
		@Column(name = "email")
		private String email;
		@Column(name = "course")
		private String course;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getStudentNumber() {
			return studentNumber;
		}
		public void setStudentNumber(String studentNumber) {
			this.studentNumber = studentNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		
		
	}


