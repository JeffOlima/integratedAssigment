package com.integratedAssessment.cct.services;

import com.integratedAssessment.cct.Exceptions.CritograpyException;
import com.integratedAssessment.cct.Exceptions.EmailExistsException;
import com.integratedAssessment.cct.model.User;
import com.integratedAssessment.cct.repository.UserRepository;
import com.integratedAssessment.cct.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser (User user) throws Exception{
        try{
//            if(UserRepository.findByEmail(user.getEmail())!= null){
//                throw new EmailExistsException("Email already registered on our database: "+user.getEmail());
//            }
            user.setPassword(Util.md5(user.getPassword()));
        }catch (Exception e){
            throw new CritograpyException("Error when cryptographing password");
        }

    }
}
