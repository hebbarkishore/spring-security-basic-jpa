//package com.example.programs;
//
//import org.junit.jupiter.api.Test;
////import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.security.spring.example.entity.AddressEntity;
//import com.security.spring.example.entity.PersonEntity;
//import com.security.spring.example.repository.AddressRepository;
//import com.security.spring.example.repository.PersonRepository;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest//It tells bootstrap with Spring Boot’s support (e.g. load application.properties and give me all the Spring Boot goodness)
//class JpaDataExampleApplicationTests {
//	
//	@Autowired
//    private RestTemplate restTemplate;
//	
//	@Autowired
//	private PersonRepository personRepository;
//	
//	
//	@Autowired
//	private AddressRepository addressRepository;
//
//	//@Test
//	public void testRestTemplate() {
//		
//		ResponseEntity<String> resp = restTemplate.getForEntity("http://40bcf9e2-558a-4f4c-8a42-5548768f43c6.mock.pstmn.io/employee/" + 12, String.class);
//		System.out.println("resp::"+resp);
//	}
//	
//	//@Test
//	public void testOneToOneMapping() {
//		
//		personRepository.deleteAllInBatch();
//		addressRepository.deleteAllInBatch();
//		
//		PersonEntity person = new PersonEntity();
//		person.setName("KSH");
//		
//		AddressEntity addr = new AddressEntity();
//		addr.setState("MA");
//		
//		person.setAddress(addr);
//		
//		addr.setPerson(person);
//		
//		personRepository.save(person);
//		
//	}
//
//}
