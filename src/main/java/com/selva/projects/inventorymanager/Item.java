package com.selva.projects.inventorymanager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Item {

	@Min(value=0 , message="itemid should be > 0")
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=3 , message ="name should atleast be 3 chars")
	private String name;
	private String type;
	
	public Item() {
		super();
	}
	
	public Item(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
}
