package com.integratedAssessment.cct.repository;


import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.Enums.MusicalGenre;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    
	List<User> findByMusicalGenre(MusicalGenre musicalGenre);
    
    
}

