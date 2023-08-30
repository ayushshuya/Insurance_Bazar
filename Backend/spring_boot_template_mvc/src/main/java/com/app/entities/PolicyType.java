package com.app.entities;

public enum PolicyType {
	TWO_WHEELER_FIRST_PARTY(1000),TWO_WHEELER_THIRD_PARTY(500),FOUR_WHEELER_FIRST_PARTY(2000),FOUR_WHEELER_THIRD_PARTY(1500);

	private double policyCost;
	
	private PolicyType(double policyCost) {
		
		this.policyCost=policyCost;;
	}

	public double getPolicyCost() {
		return policyCost;
	}

	

}



