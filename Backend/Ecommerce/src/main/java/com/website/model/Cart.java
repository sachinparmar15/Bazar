package com.website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")//Create a table in database with name cart
public class Cart {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincreament and auto generated value
	private int cartId;

	@OneToOne //one to one relationship with user one user can only have one cart
	private User user;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)// one to many relationship with cartitems
	private List<Cartitem> cartitems;

	//constructor which Constructs an Cart object with specified value
	public Cart(int cartId, User user, List<Cartitem> cartitems) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.cartitems = cartitems;
	}

	//Default constructor
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public List<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

}
