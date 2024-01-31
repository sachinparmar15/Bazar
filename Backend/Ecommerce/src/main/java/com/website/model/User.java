package com.website.model;

import jakarta.persistence.Column;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment and auto generated values
	private int userid;
	
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;
	
	@NotEmpty(message = "Password cannot be empty")
    private String password;
	
	//Email will be unique and no two user can have same email
	@Column(name = "email", unique = true, nullable = false)
    @Email(message = "Invalid email format")
	private String email;
	

	//Phone no. can only have 10 digit
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String phone;
	
	//isAdmin to show some additional features to admin 
	@Column(columnDefinition = "boolean default false")
    private boolean isAdmin;

	@Embedded
	private Address address;

	
	//Constructs an User object with specified values
	public User(int userid, String name, String password, String email, String phone, Address address) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	//Default Constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and Setters of above parameters
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
