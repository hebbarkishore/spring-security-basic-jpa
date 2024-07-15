package com.security.spring.example.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.security.spring.example.exception.ApplicationException;

@Service
public class ValidatorEndpoint {
	
	private final Logger log = LoggerFactory.getLogger(ValidatorEndpoint.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value( "${validator.username}" )
	private String id;
	
	@Value( "${validator.password}" )
	private String passwd;
	
	@Value( "${validator.url}" )
	private String url;
	
	public boolean validateUser(String id) throws ApplicationException {
		try {
			log.info("Requesting TotalSpaceCount");
			HttpHeaders headers = new HttpHeaders();
			headers.setBasicAuth(id, passwd);
			String uri = this.url + "/12";			
			ResponseEntity<String> result = null;
			HttpEntity<String> request = new HttpEntity<>(headers);
			result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
			log.info("Total Spaces in confluence:"+result.getBody());
			if( result.getBody().equals("KSH"))
				return true;
			return false;			
		} catch(Exception e) {
			log.error("Exception in validateUser:"+e,e);
			throw new ApplicationException("Failed to validate the user");
		}
	}
}
