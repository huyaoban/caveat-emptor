package com.huyaoban.caveatemptor.model;

public class CreditCard extends BillingDetails {
	
	private CreditCardType type;
	private String number;
	private String expMonth;
	private String expYear;
	
	public CreditCard() {
		super();
	}
	
	public CreditCard(String owner, User user, String number, CreditCardType type, String expMonth, String expYear) {
		super(owner, user);
		this.type = type;
		this.number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}
	
	public CreditCardType getType() {
		return type;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getExpMonth() {
		return expMonth;
	}
	
	public String getExpYear() {
		return expYear;
	}
	
	public String toString() {
		return  "CreditCard ('" + getId() + "'), " +
				"Type: '" + getType() + "'";
	}

	@Override
	public boolean isValid() {
		return getType().isValid(this);
	}

}
