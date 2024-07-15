package com.security.spring.example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.spring.example.endpoint.ValidatorEndpoint;
import com.security.spring.example.entity.CartEntity;
import com.security.spring.example.entity.PersonEntity;
import com.security.spring.example.exception.ApplicationException;
import com.security.spring.example.repository.CartRepository;
import com.security.spring.example.repository.PersonRepository;

@Service
public class GeneralServices {
	private static final Logger logger = LoggerFactory.getLogger(GeneralServices.class);

	@Autowired
	private ValidatorEndpoint validator;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Transactional
	public PersonEntity getPersonDetails(String personName) throws ApplicationException {
		logger.info("Inside the getPersonDetails");
		if (!validator.validateUser(personName)) {
			throw new ApplicationException("Invalid user");
		}

		return personRepository.findByName(personName);
	}
	
	
	@Transactional
	public PersonEntity savePersonAndMail(PersonEntity entity) throws ApplicationException {
		logger.info("Inside the savePersonAndMail");
		
		return personRepository.save(entity);
	}
	
	@Transactional
	public CartEntity getCartDetails(String cartName) throws ApplicationException {
		logger.info("Inside the getCartDetails");

		return cartRepository.findByName(cartName);
	}
}
