package com.security.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.example.entity.User;

/**
 * 
 * @author Kishore Hebbar
 *
 */ 

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	User findByUsername(String username);
}
