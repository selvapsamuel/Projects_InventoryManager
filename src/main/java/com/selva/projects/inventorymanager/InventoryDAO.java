package com.selva.projects.inventorymanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class InventoryDAO {

	private static List<Item> items = new ArrayList<>();

	static {
		items.add(new Item(1, "shirt", "cloth"));
		items.add(new Item(2, "t-shirt", "cloth"));
		items.add(new Item(3, "trouser", "cloth"));
	}

	public Item findOne(int itemid) {

		for (Item item : items) {
			if (item.getItemId() == itemid)
				return item;
		}
		return null;
	}

	public List<Item> findAll() {
		return items;
	}

	public Item addItem(Item item) {
		if(item.getItemId()==0)
			item.setItemId(items.size()+1);
		items.add(item);
		
		return item;
	}
	
	public void removeItem(int itemid) {
		boolean itemfound = false;
		Iterator<Item> iterator = items.iterator();
		while(iterator.hasNext()) {
			Item item = iterator.next();
			if (item.getItemId() == itemid) {
				iterator.remove();
				itemfound =true;
			}
		}
		
		if(!itemfound)
			throw new ItemNotFoundException("Item with id "+itemid+" not found");
	}
}
