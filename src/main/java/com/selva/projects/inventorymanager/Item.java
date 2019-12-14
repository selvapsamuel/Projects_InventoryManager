package com.selva.projects.inventorymanager;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Min(value=0 , message="itemid should be > 0")
	@Id
	@GeneratedValue
	private int itemId;
	
	@Size(min=3 , message ="name should atleast be 3 chars")
	private String name;
	private String type;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinTable(name = "ITEMSONRACK",
    	joinColumns = @JoinColumn(name = "itemId"),
    	inverseJoinColumns = @JoinColumn(name = "rackId"))
	@JsonIgnore
	private Rack rack;
	
	public Item() {
		super();
	}
	
	
	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public Item(@Min(value = 0, message = "itemid should be > 0") int itemId,
			@Size(min = 3, message = "name should atleast be 3 chars") String name, String type) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", type=" + type + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public Rack getRack() {
		return rack;
	}


	public void setRack(Rack rack) {
		this.rack = rack;
	}


	
	
}
