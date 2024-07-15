package com.security.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.spring.example.entity.ItemsEntity;

public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {

}
