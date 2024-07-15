package com.security.spring.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring.example.entity.CartEntity;
import com.security.spring.example.entity.PersonEntity;
import com.security.spring.example.exception.ApplicationException;
import com.security.spring.example.services.GeneralServices;

@RestController 
@RequestMapping(value = "/information", produces = { MediaType.APPLICATION_JSON_VALUE, //
        MediaType.APPLICATION_XML_VALUE })
public class GeneralController {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	@Autowired
	private GeneralServices generalService;
	
	@GetMapping("/persons/{personName}")
    public PersonEntity getPersonDetails(@PathVariable String personName) throws ApplicationException {
		logger.info("Inside the persons method");
		return generalService.getPersonDetails(personName);
    }
	
	
	@PostMapping("/persons/insert")
	public PersonEntity savePersonWithAddress(@RequestBody PersonEntity person) throws ApplicationException {
		return generalService.savePersonAndMail(person);
	}
	
	@GetMapping("/carts/{cartName}")
    public CartEntity getCartDetails(@PathVariable String cartName) throws ApplicationException {
		return generalService.getCartDetails(cartName);
    }
}
