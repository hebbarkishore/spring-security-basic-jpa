package com.security.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.example.entity.PersonEntity;


@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long>{
	public PersonEntity findByName(String personName);
}
