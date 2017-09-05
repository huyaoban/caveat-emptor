package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.util.Date;

public abstract class BillingDetails implements Serializable, Comparable {
	private Long id = null;
	private int version = 0;
	
	private String owner;
	private User user;
	
	private Date created = new Date();
	
	public BillingDetails() {
		
	}
	
	public BillingDetails(String owner, User user) {
		this.owner = owner;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	
	public int getVersion() {
		return version;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public User getUser() {
		return user;
	}
	
	public Date getCreated() {
		return created;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		
		if(!(o instanceof BillingDetails))
			return false;
		
		final BillingDetails billingDetails = (BillingDetails)o;
		if(!(created.getTime() == billingDetails.getCreated().getTime()))
			return false;
		
		if(!(getOwner().equals(billingDetails.getOwner())))
			return false;
		
		return true;
	}
	
	public int hashCode() {
		int result;
		result = getCreated().hashCode();
		result = result * 29 + getOwner().hashCode();
		return result;
	}
	
	public int compareTo(Object o) {
		if(o instanceof BillingDetails) {
			return Long.valueOf(getCreated().getTime()).compareTo(Long.valueOf(((BillingDetails)o).getCreated().getTime()));
		}
		
		return 0;
	}
	
	public abstract boolean isValid();
	
}
