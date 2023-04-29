package com.integratedAssessment.cct.repository;


import com.integratedAssessment.cct.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
