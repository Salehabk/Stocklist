package com.qa.stocklist.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.stocklist.entity.Item;
import com.qa.stocklist.repos.ItemRepo;

@Service
public class ItemService {

	ItemRepo repo;
	
	@Autowired
	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	public Item create(Item item) {
		return repo.save(item);
	}
	
	public List<Item> getAll() {
		return repo.findAll();
	}
	

	public Item readByID(long id) {
		Optional<Item> option = repo.findById(id);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	public void update(Item item, int id)
	{  
	this.repo.save(item);  
	}  
	
	public void delete(Item item) {
		repo.deleteById(item.getId());
	}





	}



			

