package com.integratedAssessment.cct.controllers;


import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String registerStudent(@ModelAttribute Student student, Model model) {
	    String id = UUID.randomUUID().toString(); // create a unique String ID
	    student.setId(id);
	    Student savedStudent = studentRepository.save(student);
	    return "redirect:/registered-students";
	}
	

	@GetMapping("registered-students")
	public ModelAndView listingStudents() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Student/studentList");
		mv.addObject("studentList",studentRepository.findAll());
		return mv;
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("Student/edit");
	    Optional<Student> student = studentRepository.findById(id);
	    if (student.isPresent()) {
	        mv.addObject("student", student.get());
	    } else {
	        // Handle the case when the student is not found by ID
	    }
	    return mv;
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(Student student) {
		ModelAndView mv = new ModelAndView();
		studentRepository.save(student);
		mv.setViewName("redirect:/registered-students");
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") String id) {
		studentRepository.deleteById(id);
		return "redirect:/registered-students";
	}
	

}
	

