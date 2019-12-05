package com.selva.projects.inventorymanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/items")
	public List<Item> itemList(){
		
		return inventoryService.findAll();
	}
	
	@GetMapping("/items/{itemid}")
	public Item findItem(@PathVariable int itemid){
		
		return inventoryService.findOne(itemid);
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
