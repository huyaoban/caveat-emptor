package com.huyaoban.caveatemptor.model;

import java.util.Date;

public class Shipment {
	private Long id = null;
    private int version = 0;
    
    private AddressEntity deliveryAddress;
    
    private Item auction;
    
    private User buyer;
    private User seller;
    
    private int inspectionPeriodDays;
    private ShipmentState state = ShipmentState.AGREED;
    private Date created = new Date();
    
    public Shipment() {
    	
    }
    
    public Shipment(AddressEntity deliveryAddress, User buyer, User seller, int inspectionPeriodDays) {
        this.deliveryAddress = deliveryAddress;
        this.buyer = buyer;
        this.seller = seller;
        this.inspectionPeriodDays = inspectionPeriodDays;
    }
    
    public Long getId() { 
    	return id; 
    }
    
    public int getVersion() { 
    	return version; 
    }

    public AddressEntity getDeliveryAddress() { 
    	return deliveryAddress; 
    }
    
    public Item getAuction() { 
    	return auction; 
    }
    
    public void setAuction(Item auction) { 
    	this.auction = auction; 
    }

    public User getSeller() { 
    	return seller; 
    }

    public User getBuyer() { 
    	return buyer; 
    }
    
    public int getInspectionPeriodDays() { 
    	return inspectionPeriodDays; 
    }

    public ShipmentState getState() { 
    	return state; 
    }
    
    public void setState(ShipmentState state) { 
    	this.state = state; 
    }

    public Date getCreated() { 
    	return created; 
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shipment)) return false;

        final Shipment shipment = (Shipment) o;

        if (inspectionPeriodDays != shipment.inspectionPeriodDays) return false;
        if (!buyer.getId().equals(shipment.buyer.getId())) return false;
        if (!created.equals(shipment.created)) return false;
        return seller.getId().equals(shipment.seller.getId());

    }

    public int hashCode() {
        int result;
        result = seller.getId().hashCode();
        result = 29 * result + buyer.getId().hashCode();
        result = 29 * result + inspectionPeriodDays;
        result = 29 * result + created.hashCode();
        return result;
    }

    public String toString() {
        return  "Shipment ('" + getId() + "'), " +
                "State: '" + getState() + "'";
    }
}
