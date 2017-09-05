package com.huyaoban.caveatemptor.model;

public enum CreditCardType {
	MASTERCARD("Mastercard"),
	VISA("Visa"),
	AMEX("American Express");
	
	private final String debugName;
	
	private CreditCardType(String debugName) {
		this.debugName = debugName;
	}
	
	public String toString() {
		return debugName;
	}
	
	public boolean isValid(CreditCard cc) {
		return true;
	}

}
