package com.selva.projects.inventorymanager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryDAO inventoryDao;
	
	@Autowired
	private ItemRepository itemRepository;

	public Item findOne(int itemid) {

		Optional<Item> item = itemRepository.findById(itemid);
		if (!item.isPresent())
			throw new ItemNotFoundException("Item with id " + itemid + " Not found");
		return item.get();

	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	public void removeItem(int itemid) {
		itemRepository.deleteById(itemid);
	}
}
