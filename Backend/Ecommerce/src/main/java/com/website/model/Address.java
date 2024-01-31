package com.website.model;



import javax.validation.constraints.Pattern;

import jakarta.persistence.Embeddable;

//Embeddable will join this with user table 
@Embeddable
public class Address {
	private String houseNo;

	private String area;

	private String landmark;

	private String village;

	private String city;

	private String state;

	//pincode can have only 6 digits
	@Pattern(regexp = "\\d{6}", message = "Pincode  must be of 6 digits")
	private int pincode;

	//Getters and Setters of above parameters
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
