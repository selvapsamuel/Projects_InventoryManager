package com.selva.projects.inventorymanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InventoryDAO {

	private static List<Item> items = new ArrayList<>();

	static {
		items.add(new Item(1, "shirt", "cloth"));
		items.add(new Item(2, "t-shirt", "cloth"));
		items.add(new Item(3, "trouser", "cloth"));
	}

	public Item findOne(int itemid) {

		for (Item item : items) {
			if (item.getId() == itemid)
				return item;
		}
		return null;
	}

	public List<Item> findAll() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
}
