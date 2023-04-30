package com.integratedAssessment.cct.controllers;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("/registerUsers")
	public ModelAndView RegisterUsers(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("User/formUser");
		mv.addObject("user", new User());
		return mv;
	}


	@PostMapping("/registerUsers")
	public String registerUser(@ModelAttribute User user, Model model) {
	    String id = UUID.randomUUID().toString(); // create a unique String ID
	    user.setId(id);
	    User savedUser = userRepository.save(user);
	    return "redirect:/registered-users";
	}
	

	@GetMapping("registered-users")
	public ModelAndView listingUsers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("User/userList");
		mv.addObject("userList",userRepository.findAll());
		return mv;
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/edit");
	    Optional<User> user = userRepository.findById(id);
	    if (user.isPresent()) {
	        mv.addObject("user", user.get());
	    } else {
	        // Handle the case when the student is not found by ID
	    }
	    return mv;
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(User user) {
		ModelAndView mv = new ModelAndView();
		userRepository.save(user);
		mv.setViewName("redirect:/registered-users");
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userRepository.deleteById(id);
		return "redirect:/registered-users";
	}
	

}
	

