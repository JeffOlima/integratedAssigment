package com.integratedAssessment.cct.controllers;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.integratedAssessment.cct.Enums.MusicalGenre;
import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.repository.UserRepository;

import jakarta.validation.Valid;

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
	public String registerUser(@ModelAttribute @Valid User user, BindingResult br) {
	    String id = UUID.randomUUID().toString(); // create a unique String ID
	    if(br.hasErrors()){
	        return "User/formUser";
	    } else {
	        user.setId(id);
	        User savedUser = userRepository.save(user );
	        return "redirect:/registered-users";
	    }
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
	
	@GetMapping("users-filter")
	public ModelAndView usersFilter() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("User/usersFilter");
		return mv;
	}
	
	@GetMapping("users-rock")
	public ModelAndView listingUsersRock() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/users-rock");
	    mv.addObject("usersRock", userRepository.findByMusicalGenre(MusicalGenre.ROCK));
	    return mv;
	}
	
	@GetMapping("users-classic")
	public ModelAndView listingUsersClassic() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/users-classic");
	    mv.addObject("usersClassic", userRepository.findByMusicalGenre(MusicalGenre.CLASSIC));
	    return mv;
	}
	
	@GetMapping("users-pop")
	public ModelAndView listingUsersPop() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/users-pop");
	    mv.addObject("usersPop", userRepository.findByMusicalGenre(MusicalGenre.POP));
	    return mv;
	}
	
	@GetMapping("users-rap")
	public ModelAndView listingUsersRap() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/users-rap");
	    mv.addObject("usersRap", userRepository.findByMusicalGenre(MusicalGenre.RAP));
	    return mv;
	}
	
	@GetMapping("users-reggae")
	public ModelAndView listingUsersReggae() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("User/users-reggae");
	    mv.addObject("usersReggae", userRepository.findByMusicalGenre(MusicalGenre.REGGAE));
	    return mv;
	}
	
}
	

