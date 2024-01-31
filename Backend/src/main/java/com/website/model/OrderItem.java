
package com.website.model;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity //generate a table in database
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderitemid;

	//Establish a many to one relationship with product
	@ManyToOne
	private Product product;
	
	@Positive
	private int quantity;
	@Positive
	private int orderPrice;

	@ManyToOne
	@JoinColumn(name = "orderid")
	@JsonIgnore
	private Order order;

	//Constructor using field which will Constructs an OrderItem object with specified values
	public OrderItem(int orderitemid, Product product, int quantity, Order order) {
		
		this.orderitemid = orderitemid;
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}

	public OrderItem() {
	}

	// Getters and Setters for this
	public int getOrderItemId() {
		return orderitemid;
	}

	public void setOrderItemId(int orderitemid) {
		this.orderitemid = orderitemid;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrderPrice(Product product) {
		this.orderPrice = product.getPrice();
	}

	public double getOrderPrice() {
		return orderPrice;
	}

}