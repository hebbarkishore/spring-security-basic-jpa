package com.security.spring.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Items")
public class ItemsEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="cart_id", nullable=false)
	@JsonBackReference
	private CartEntity cart;
	
	@Column(name = "name")
	private String itemName;
	
	public ItemsEntity() {
	}
	

	public ItemsEntity(CartEntity cart, String itemName) {
		this.cart = cart;
		this.itemName = itemName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CartEntity getCart() {
		return cart;
	}


	public void setCart(CartEntity cart) {
		this.cart = cart;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
