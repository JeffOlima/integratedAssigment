package com.integratedAssessment.cct.repository;


import com.integratedAssessment.cct.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
