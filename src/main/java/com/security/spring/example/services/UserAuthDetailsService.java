package com.security.spring.example.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.spring.example.entity.User;
import com.security.spring.example.model.UserPrincipal;
import com.security.spring.example.repository.UserRepository;


/**
 * 
 * @author Kishore Hebbar
 *
 */ 

@Component
public class UserAuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    
    private final Logger log = LoggerFactory.getLogger(UserAuthDetailsService.class);

    public UserAuthDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
    	log.info("inside the loaduser");
    	User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
    	log.info("user is:"+user.getUsername()+", password:"+user.getPassword());
        return UserPrincipal.create(user);
    }
}
