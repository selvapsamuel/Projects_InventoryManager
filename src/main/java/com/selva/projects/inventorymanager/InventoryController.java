package com.selva.projects.inventorymanager;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/items")
	public List<Item> itemList() {

		return inventoryService.findAll();
	}

	@GetMapping(value="/items/{itemid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Item> findItem(@PathVariable int itemid) {
		Item item = inventoryService.findOne(itemid);
		
		Resource<Item> resource = new Resource<Item>(item);
		ControllerLinkBuilder link =linkTo(methodOn(this.getClass()).itemList());
		resource.add(link.withRel("all-items"));
		return resource;
	}

	@PostMapping("/items")
	public ResponseEntity addItem(@Valid @RequestBody Item item) {
		Item savedItem = inventoryService.addItem(item);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedItem.getId())
				.toUri();
		return ResponseEntity.created(loc).build();
	}

	@DeleteMapping("/items/{itemid}")
	public void removeItem(@PathVariable int itemid) {
		inventoryService.removeItem(itemid);
	}
	
	@GetMapping("/welcome-message")
	public String getWelcomeMessage() {
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}
}
