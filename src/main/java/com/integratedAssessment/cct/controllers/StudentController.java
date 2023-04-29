package com.integratedAssessment.cct.controllers;


import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.integratedAssessment.cct.model.Student;
import com.integratedAssessment.cct.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("/registerStudents")
	public ModelAndView RegisterStudents(Student student) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Student/formStudent");
		mv.addObject("student", new Student());
		return mv;
	}
	

	
	@PostMapping("/registerStudent")
	public ResponseEntity<String> registerStudent(@ModelAttribute Student student, Model model) {
	    String id = UUID.randomUUID().toString(); // create a unique String ID
	    student.setId(id);
	    Student savedStudent = studentRepository.save(student);
	    return ResponseEntity.ok("Student saved with ID " + savedStudent.getId());
	}
}
	
//@GetMapping("/students/{id}")
//public ResponseEntity<Student> getStudentById(@PathVariable String id) {
//    Optional<Student> optionalStudent = studentRepository.findById(id); // buscar o Student com o ID fornecido
//    if (optionalStudent.isPresent()) {
//        Student student = optionalStudent.get();
//        return ResponseEntity.ok(student); // retornar o Student encontrado
//    } else {
//        return ResponseEntity.notFound().build(); // retornar um erro 404 se não for encontrado nenhum Student com o ID fornecido
//    }
//}
//
//


