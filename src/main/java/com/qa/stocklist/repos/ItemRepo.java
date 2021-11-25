package com.qa.stocklist.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.stocklist.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> { 
	List<Item> findItemByName(String name);
	List<Item> findItemByQuantity(Integer quantity);
}


