package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Category implements Serializable, Comparable {
	private Long id = null;
	private int version = 0;
	
	private String name;
	private List<Category> childCategories = new ArrayList<Category>();
	private Category parentCategory;
	
	private List<Item> items = new ArrayList<Item>();
	private Set<CategorizedItem> categorizedItems = new HashSet<CategorizedItem>();
	private Set<CategorizedItemComponent> categorizedItemComponents = new HashSet<CategorizedItemComponent>();
	private Map<Item, User> itemsAndUser = new HashMap<Item, User>();
	
	private Date created = new Date();
	
	public Category() {
		
	}
	
	public Category(String name,
					List<Category> childCategories,
					Category parentCategory,
					List<Item> items,
					Set<CategorizedItem> categorizedItems,
					Set<CategorizedItemComponent> categorizedItemComponents,
					Map<Item, User> itemsAndUser) {
		this.name = name;
		this.childCategories = childCategories;
		this.parentCategory = parentCategory;
		this.items = items;
		this.categorizedItems = categorizedItems;
		this.categorizedItemComponents = categorizedItemComponents;
		this.itemsAndUser = itemsAndUser;
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(String name, Category parentCategory) {
		this.name = name;
		this.parentCategory = parentCategory;
	}

	public Long getId() {
		return id;
	}
	
	public int getVersion() {
		return version;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Category> getChildCategories() {
		return this.childCategories;
	}
	
	public void addChildCategory(Category childCategory) {
		if(childCategory == null)
			throw new IllegalArgumentException("Null child category!");
	}
}
