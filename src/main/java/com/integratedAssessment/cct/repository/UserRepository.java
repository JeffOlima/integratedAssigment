package com.integratedAssessment.cct.repository;


import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.Enums.MusicalGenre;

import java.util.List;

import jakarta.validation.constraints.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
	List<User> findByMusicalGenre(MusicalGenre musicalGenre);


	public User findByEmail(String email);

	public User searchByEmailAndPassword(String email,String password);

}

