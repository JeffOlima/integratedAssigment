package com.integratedAssessment.cct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import com.integratedAssessment.cct.Enums.MusicalGenre;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Document(collection = "users")
@Entity
public class User {
		
		@Id
		private String id;
		@Column(name = "name")
		@Size(min = 5, max = 20, message = "The name has to conten at least 5 characters")
		@NotBlank(message ="the name can not be empty")
		private String name;
		
		@Column(name = "surname") 
		@NotBlank(message ="the surname can not be empty")
		private String surname;
		
		@Column(name = "userNumber")
		private String userNumber;
		
		@Column(name = "email")
		@NotBlank(message ="the email can not be empty")
		@Email()
		private String email;
		
		@Column(name = "musicalGenre")
		private MusicalGenre musicalGenre;
		
		
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
		public String getUserNumber() {
			return userNumber;
		}
		public void setUserNumber(String userNumber) {
			this.userNumber = userNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public MusicalGenre getMusicalGenre() {
			return musicalGenre;
		}
		public void setMusicalGenre(MusicalGenre musicalGenre) {
			this.musicalGenre = musicalGenre;
		}
		
		
	}


