package com.website.model;


public class FilterRequest {
    private int maxValue;
    private int minValue;
    private String orderBy;
    
    
    
    
	public FilterRequest(int maxValue, int minValue, String orderBy) {
		super();
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.orderBy = orderBy;
	}
	
	
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

    
    
    // Add getters and setters
}
