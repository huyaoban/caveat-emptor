package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.sql.Date;

public class Bid implements Serializable, Comparable {
	private Long id = null;
	private MonetaryAmount amount;
	private Item item;
	private User bidder;
	private Date created = new Date();
	private boolean successful = false;
	
	public Bid() {
		
	}
	
	public Bid(MonetaryAmount amount, Item item, User bidder) {
		this.amount = amount;
		this.item = item;
		this.bidder = bidder;
	}
	
	public Long getId() {
		return id;
	}
	
	public MonetaryAmount getAmount() {
		return amount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public User getBidder() {
		return bidder;
	}
	
	public Date getCreated() {
		return created;
	}

	public boolean isSuccessful() {
		return successful;
	}
	
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	public boolean equlas(Object o) {
		if(this == o)
			return true;
		
		if(!(o instanceof Bid))
			return false;
		
		final Bid bid = (Bid)o;
		
		if(!getItem().getId().equal(bid.getItem().getId()))
			return false;
		
		if(!(getCreated().getTime() == bid.getCreated().getTime()))
			return false;
		
		if(!getAmount().equals(bid.getAmount()))
			return false;
		
		return true;
	}
	
	public int hashCode() {
		int result;
		result = amount.hashCode();
		result = 29 * result + created.hashCode();
		return result;
	}
	
	public String toString() {
		return  "Bid ('" + getId() + "'), " +
				"Created: '" + getCreated() + "' " +
				"Amount: '" + getAmount() + "'";
	}
	
	public int compareTo(Object o) {
		if (o instanceof Bid) {
            // Don't compare Date objects! Use the time in milliseconds!
            return Long.valueOf(this.getCreated().getTime()).compareTo(
                    Long.valueOf( ((Bid)o).getCreated().getTime())
                   );
		}
		return 0;
	}
}
