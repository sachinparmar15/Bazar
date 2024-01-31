package com.website.model;

import javax.validation.constraints.Positive;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//generating table in database
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated value  
	private int productid; //primary key

	private String name;

	@Positive(message = "Price must be a positive value")
	private int price; //price cannot be negative

	private String details;

	private String category;

	// To store image
	private String img;

	public Product() {

	}

	// Constructs an Product object with specified values
	public Product(int productid, String name,  int price,
			String details, String category, String img) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.details = details;
		this.category = category;
		this.img = img;
	}

	// Getters and Setters of above parameters
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
