package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale.Category;

import org.hibernate.cache.ReadWriteCache.Item;

public class CategorizedItemComponent implements Serializable, Comparable {
	private String username;
	private Date dateAdded = new Date();
	private Category category;
	private Item item;

	public CategorizedItemComponent() {
		
	}
	
	public CategorizedItemComponent(String username, Category category, Item item) {
		this.username = username;
		this.category = category;
		this.item = item;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean equals(Object o) {
		if(this == o)
			return true;
		
		if(o == null || this.getClass() != o.getClass())
			return false;
		
		final CategorizedItemComponent that = (CategorizedItemComponent)o;
		if(!category.equals(that.getCategory()))
			return false;
		if(!item.equals(that.getItem()))
			return false;
		if(!username.equals(that.getUsername()))
			return false;
		if(!dateAdded.equals(that.getDateAdded()))
			return false;
		
		return true;
	}
	
	public int hashCode() {
        int result;
        result = username.hashCode();
        result = 29 * result + dateAdded.hashCode();
        result = 29 * result + item.hashCode();
        result = 29 * result + category.hashCode();
        return result;
    }
	
	public int compareTo(Object o) {
		// CategorizedItems are sorted by date
		if (o instanceof CategorizedItemComponent)
			return getDateAdded().compareTo( ((CategorizedItemComponent)o).getDateAdded() );
		return 0;
	}
	
	public String toString() {
		return  "Added by: '" + getUsername() + "', " +
				"On Date: '" + getDateAdded();
	}
}
