package com.security.spring.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController 
@RequestMapping(value = "/testController", produces = { MediaType.APPLICATION_JSON_VALUE, //
        MediaType.APPLICATION_XML_VALUE })
public class TestController {

	@GetMapping
    public String getEmployees() {
        return "Hello test";
    }
	
}
