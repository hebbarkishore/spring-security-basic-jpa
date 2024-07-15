package com.security.spring.example;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.spring.example.entity.AddressEntity;
import com.security.spring.example.entity.CartEntity;
import com.security.spring.example.entity.ItemsEntity;
import com.security.spring.example.entity.PersonEntity;
import com.security.spring.example.entity.User;
import com.security.spring.example.repository.CartRepository;
import com.security.spring.example.repository.PersonRepository;
import com.security.spring.example.repository.UserRepository;


@SpringBootApplication
public class JpaDataExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDataExampleApplication.class, args);
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	ApplicationRunner init(UserRepository userRepository) {
		return (args) ->  dataSetup(userRepository);
	}
	
	@Autowired
	private PersonRepository personRepository;	
	
	
	@Autowired
	private CartRepository cartRepository; 
	
	
	private void dataSetup(UserRepository userRepository) {
		User admin = new User("admin", passwordEncoder.encode("adminPasswd"), "ROLE_ADMIN");
		User user1 = new User("user1", passwordEncoder.encode("testMe"), "ROLE_USER");
		userRepository.save(admin);
		userRepository.save(user1);
		
		//>>Start : one-one Initialization between Person and Address 
		//personRepository.deleteAllInBatch();
		//addressRepository.deleteAllInBatch();
		
		PersonEntity person = new PersonEntity();
		person.setName("KSH");
		
		AddressEntity addr = new AddressEntity();
		addr.setState("MA");
		
		person.setAddress(addr);
		
		addr.setPerson(person);
		
		personRepository.save(person);
		//<<End - one-one
		
		//>>Start : one-many initialization between cart and item
		//itemsRepository.deleteAllInBatch();
		//cartRepository.deleteAllInBatch();		
		CartEntity cart = new CartEntity();
		cart.setName("ISR20");
		
		Set<ItemsEntity> items = new HashSet<>();
		
		ItemsEntity item1 = new ItemsEntity();
		item1.setItemName("Vegetables");
		item1.setCart(cart);
		items.add(item1);
		
		ItemsEntity item2 = new ItemsEntity();
		item2.setItemName("milk");
		item2.setCart(cart);
		items.add(item2);
				
		cart.setItems(items);
		cartRepository.save(cart);
		//<<End : one-many
	}
}
