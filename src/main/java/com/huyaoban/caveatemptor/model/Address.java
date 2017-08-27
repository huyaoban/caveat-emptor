package com.huyaoban.caveatemptor.model;

import java.io.Serializable;

public class Address implements Serializable {
	private String city;
	private String street;
	private String zipcode;
	
	public Address() {
		
	}
	
	public Address(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public boolean equal(Object o) {
		if(this == o)
			return true;
		
		if(!(o instanceof Address))
			return false;
		
		final Address address = (Address)o;
		
		if(!city.equals(address.city))
			return false;
		
		if(!street.equals(address.street))
			return false;
		
		if(!zipcode.equals(address.zipcode))
			return false;
		
		return true;
	}
	
	public int hashCode() {
		int result;
		result = street.hashCode();
		result = 29 * result + zipcode.hashCode();
		result = 29 * result + city.hashCode();
		
		return result;
	}

	public String toString() {
		return "Street: " + getStreet() + "," + 
				"Zipcode: " + getZipcode() + "," + 
				"City: " + getCity();
				
	}
}
