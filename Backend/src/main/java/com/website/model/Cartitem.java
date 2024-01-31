
package com.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "cartitem") //generate a table with name cartitem in database
public class Cartitem {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate value and autoincrement
	private int id;

	@ManyToOne
	@JoinColumn(name = "cart")
	@JsonIgnore
	private Cart cart; //it will have many to one relationship with cart

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private int quantity;

    //Constructs an Cartitem object with specified value
	public Cartitem(int id, Cart cart, Product product, int quantity) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
	
	

	//Default constructor
	public Cartitem() {
		super();
		// TODO Auto-generated constructor stub
	}



	//getters and setters of above parameter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}