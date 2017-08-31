package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.util.Date;

public class CategorizedItem implements Serializable, Comparable {
	
	public static class Id implements Serializable {
		private Long categoryId;
		private Long itemId;
		
		public Id() {
			
		}
		
		public Id(Long categoryId, Long itemId) {
			this.categoryId = categoryId;
			this.itemId = itemId;
		}
		
		public boolean equals(Object o) {
			if(this == o)
				return true;
			if(!(o instanceof Id))
				return false;
			
			final Id id = (Id)o;
			if(!categoryId.equals(id.categoryId))
				return false;
			if(!itemId.equals(id.itemId))
				return false;
			
			return true;
		}
		
		public int hashCode() {
			return categoryId.hashCode() + itemId.hashCode();
		}
	}
	
	private Id id;
	private String username;
	private Date dateAdded = new Date();
	private Item item;
	private Category category;
	
	public CategorizedItem() {
		
	}
	
	public CategorizedItem(String username, Category category, Item item) {
		this.username = username;
		this.category = category;
		this.item = item;
		
		this.id = new Id(category.getId(), item.getId());
		category.getCategorizedItems().add(this);
		item.getCategorizedItems().add(this);
	}
	
	public Id getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Item getItem() {
		return item;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		
		if(o == null || this.getClass() != o.getClass())
			return false;
		
		final CategorizedItem that = (CategorizedItem)o;
		return id.equals(that.getId());
	}
	
	public int hashCode() {
		return id.hashCode();
	}
	
	public int compareTo(Object o) {
		if(o instanceof CategorizedItem) {
			return getDateAdded().compareTo(((CategorizedItem)o).getDateAdded());
		}
		return 0;
	}
	
	public String toString() {
		return  "Added by: '" + getUsername() + "', " +
				"On Date: '" + getDateAdded();
	}
}
