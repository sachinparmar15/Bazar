package com.website.model;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "orders") // name of our table
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generate value in increasing order
	@Column(name = "orderid")
	private int orderid;

	@ManyToOne
	private User userid;

	//OneToMany mapping with orderItems
	 // CascadeType.ALL ensures that operations on Order reflect to OrderItems
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	// It will Constructs an Order object with specified values
	public Order(int orderid, User userid, List<OrderItem> orderItems) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.orderItems = orderItems;
	}

	// Default Constructor
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters for all

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	// provide a string representation of the Order object
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", orderItems=" + orderItems + "]";
	}

}