package com.huyaoban.caveatemptor.model;

import java.io.Serializable;

public class AddressEntity implements Serializable {
	private Long id = null;
	private int version = 0;
	
	private String street;
	private String zipcode;
	private String city;
	
	private User user;
	
	public AddressEntity() {
		
	}
	
	public AddressEntity(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVersion() {
		return version;
	}
	
	public boolean equals(Object o) {
		if(this == o)
			return true;
		
		if(!(o instanceof AddressEntity))
			return false;
		
		final AddressEntity address = (AddressEntity)o;
		
		if(!city.equals(address.getCity()))
			return false;
		
		if(!street.equals(address.getStreet()))
			return false;
		
		if(!zipcode.equals(address.getZipcode()))
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
