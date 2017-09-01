package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.cache.ReadWriteCache.Item;

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
	
	public Category getParentCategory() {
		return this.parentCategory;
	}
	
	private void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	public void addChildCategory(Category childCategory) {
		if(childCategory == null)
			throw new IllegalArgumentException("Null child category!");
		
		if(childCategory.getParentCategory() != null) {
			childCategory.getParentCategory().getChildCategories().remove(childCategory);
		}
		childCategory.setParentCategory(parentCategory);
		childCategories.add(childCategory);
	}
	
	public void removeChildCategory(Category childCategory) {
		if(childCategory == null)
			throw new IllegalArgumentException("Null child category");
		childCategory.setParentCategory(null);
		childCategories.remove(childCategory);
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		if(item == null)
			throw new IllegalArgumentException("Null item");
		
		items.add(item);
		item.getCategories().add(this);
	}
	
	public void removeItem(Item item) {
		if(item == null)
			throw new IllegalArgumentException("Null item");
		
		items.remove(item);
		item.getCategories().remove(this);
	}
	
	public Set<CategorizedItemComponent> getCategorizedItemComponents() {
		return categorizedItemComponents;
	}
	
	public Map<Item, User> getItemsAndUser() {
		return itemsAndUser;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Category category = (Category) o;

        if (!created.equals(category.created)) return false;
        if (!name.equals(category.name)) return false;
        return !(parentCategory != null ?
                !parentCategory.equals(category.parentCategory) :
                category.parentCategory != null);

    }
	
	public int hashCode() {
        int result;
        result = name.hashCode();
        result = 29 * result + (parentCategory != null ? parentCategory.hashCode() : 0);
        result = 29 * result + created.hashCode();
        return result;
    }
	
	public int compareTo(Object o) {
        if (o instanceof Category) {
            return this.getName().compareTo( ((Category)o).getName() );
        }
        return 0;
    }
	
	public String toString() {
        return  "(" + getId() + ") Name: '" + getName();
    }
}
