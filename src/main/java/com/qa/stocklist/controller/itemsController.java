package com.qa.stocklist.controller;

	import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.qa.stocklist.entity.Item;
import com.qa.stocklist.service.ItemService;

	
	
	
	
	@RestController
	public class itemsController {
		
		private ItemService service;
		
		public itemsController(ItemService service) {
			super();
			this.service = service;
}
			
		@PostMapping("/createItem")
		public String create(@RequestBody Item item) {
		service.additem(item);
		return "Item has been added";
				
			}
		
		
		@GetMapping("/readAll")
		public List<Item> read() {
		return service.getAll();		
	}
		
		
		@GetMapping("/readByID/{id}")
		public Item readById(@PathVariable long id) {
		return service.readByID(id);
	
			}
		
	
		@PostMapping("/update/{id}")
		public String update(@PathVariable long id, @RequestBody Item item) {
		service.delete(service.readByID(id));
		item.setId(id);
		service.additem(item);
		return "Product has been updated";
		}
		
		@PostMapping("/deleteItem/{id}")
		public String delete(@PathVariable long id) {
		service.delete(service.readByID(id));
		return "Delete successful";
		}
		
		
		}

		
		
	
	
	

