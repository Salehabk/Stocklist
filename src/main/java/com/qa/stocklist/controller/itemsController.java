package com.qa.stocklist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.stocklist.entity.Item;
import com.qa.stocklist.service.ItemService;

@RestController
public class itemsController {

	private ItemService itemservice;

	public itemsController(ItemService itemservice) {
		super();
		this.itemservice = itemservice;
	}

	@PostMapping("/createItem")
	public ResponseEntity<Item> create(@RequestBody Item item) {
		return new ResponseEntity<>(itemservice.create(item), HttpStatus.CREATED);

	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Item>> read() {
		return new ResponseEntity<>(itemservice.getAll(), HttpStatus.OK);
	}

	@GetMapping("/readByID/{id}")
	public ResponseEntity<Item> readById(@PathVariable long id) {
		return new ResponseEntity<>(itemservice.readByID(id), HttpStatus.CONTINUE);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateQuantity(@PathVariable long id, @RequestBody Item item) {
		itemservice.readByID(id);
		item.setId(id);
		return new ResponseEntity<>(itemservice.update(item), HttpStatus.ACCEPTED);

	}

	@PostMapping("/deleteItem/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		itemservice.delete(itemservice.readByID(id));
		return new ResponseEntity<>("Delete successful", HttpStatus.ACCEPTED);
	}

}
