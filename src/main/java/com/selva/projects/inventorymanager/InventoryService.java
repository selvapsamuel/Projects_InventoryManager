package com.selva.projects.inventorymanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryDAO inventoryDao;

	public Item findOne(int itemid) {

		Item item = inventoryDao.findOne(itemid);
		if (item == null)
			throw new ItemNotFoundException("Item with id " + itemid + " Not found");
		return item;

	}

	public List<Item> findAll() {

		return inventoryDao.findAll();
	}

	public Item addItem(Item item) {
		return inventoryDao.addItem(item);
	}

	public void removeItem(int itemid) {
		 inventoryDao.removeItem(itemid);
	}
}
