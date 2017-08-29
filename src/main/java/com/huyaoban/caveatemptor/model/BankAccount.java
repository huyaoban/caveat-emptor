package com.huyaoban.caveatemptor.model;

public class BankAccount extends BillingDetails {
	private String account;
	private String bankname;
	private String swift;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(String owner, User user, String account, String bankname, String swift) {
		super(owner, user);
		this.account = account;
		this.bankname = bankname;
		this.swift = swift;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}
	
	public String toString() {
		return "BankAccount ('" + getId() + "'), " + 
				"Account '" + getAccount() + "'";
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
