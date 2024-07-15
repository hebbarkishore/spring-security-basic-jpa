package com.security.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.spring.example.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	public CartEntity findByName(String cartName);
}
