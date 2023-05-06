package com.integratedAssessment.cct.services;

import com.integratedAssessment.cct.Exceptions.CritograpyException;
import com.integratedAssessment.cct.Exceptions.EmailExistsException;
import com.integratedAssessment.cct.Exceptions.ServiceExc;
import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.repository.UserRepository;
import com.integratedAssessment.cct.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser (User user) throws Exception {
        try {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new EmailExistsException("Email already registered on our database: " + user.getEmail());}
            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new EmailExistsException("Username already registered on our database: " + user.getUsername());
            }
            user.setPassword(Util.md5(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new CritograpyException("Error when cryptographing password");
        }
        userRepository.save(user);
    }

        public User loginUser(String username, String password) throws ServiceExc {

            //User userLogin= userRepository.searchByEmailAndPassword(email, password);
            User userLogin= userRepository.searchByUsernameAndPassword(username , password);
            return userLogin;
        }

    }

