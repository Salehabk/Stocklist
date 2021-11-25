package com.qa.stocklist.controller;

import java.util.List;

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
	public String create(@RequestBody Item item) {
		itemservice.create(item);
		return "Item has been added";

	}

	@GetMapping("/readAll")
	public List<Item> read() {
		return itemservice.getAll();
	}

	@GetMapping("/readByID/{id}")
	public Item readById(@PathVariable long id) {
		return itemservice.readByID(id);

	}

	@PutMapping("/update/{id}")
	public String updateQuantity(@PathVariable long id, @RequestBody Item item) {
		itemservice.readByID(id);
		item.setId(id);
		itemservice.update(item);
		return "Product has been updated";
	}
	

	@PostMapping("/deleteItem/{id}")
	public String delete(@PathVariable long id) {
		itemservice.delete(itemservice.readByID(id));
		return "Delete successful";
	}
	

}
