package com.selva.projects.inventorymanager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Rack {
	
	@Id
	@GeneratedValue
	private int rackId;
	private String rackName;
	private String location;
	
	@OneToMany(mappedBy="rack", fetch=FetchType.LAZY)
	private List<Item> items;
	

	public Rack() {
		
	}


	
	public Rack(int rackId, String rackName, String location) {
		super();
		this.rackId = rackId;
		this.rackName = rackName;
		this.location = location;
	}



	@Override
	public String toString() {
		return "Rack [rackId=" + rackId + ", rackName=" + rackName + ", location=" + location + "]";
	}



	public String getRackName() {
		return rackName;
	}



	public void setRackName(String rackName) {
		this.rackName = rackName;
	}



	public int getRackId() {
		return rackId;
	}


	public void setRackId(int rackId) {
		this.rackId = rackId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}

}
