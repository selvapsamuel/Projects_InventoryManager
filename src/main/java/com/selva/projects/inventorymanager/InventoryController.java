package com.selva.projects.inventorymanager;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/items")
	public List<Item> itemList() {

		return inventoryService.findAll();
	}

	@GetMapping("/items/{itemid}")
	public Item findItem(@PathVariable int itemid) {

		return inventoryService.findOne(itemid);
	}

	@PostMapping("/items")
	public ResponseEntity addItem(@RequestBody Item item) {
		Item savedItem = inventoryService.addItem(item);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedItem.getId())
				.toUri();
		return ResponseEntity.created(loc).build();
	}

}
