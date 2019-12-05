package com.selva.projects.inventorymanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryDAO inventoryDao;

	public Item findOne(int itemid) {

		return inventoryDao.findOne(itemid);

	}

	public List<Item> findAll() {

		return inventoryDao.findAll();
	}

	public void addItem(Item item) {
		inventoryDao.addItem(item);
	}

	public InventoryDAO getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDAO inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

}
