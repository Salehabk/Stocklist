package com.qa.stocklist.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.stocklist.controller.itemsController;
import com.qa.stocklist.entity.Item;
import com.qa.stocklist.service.ItemService;

import junit.framework.Assert;

import com.qa.stocklist.repos.ItemRepo;

@SpringBootTest

class ServiceTestCase {

	@Autowired
	private ItemService service;

	@MockBean
	private ItemRepo repository;

	 
	
	 @Test
  void testCreate() {
		 Item Test_item= new Item(1, "Flour", "InStock", 5);
		 Item Test_Saved_item = new Item(1, "Flour", "InStock", 5);

		    Mockito.when(this.repository.save(Test_item)).thenReturn(Test_Saved_item);

		 assertThat(this.service.create(Test_item)).isEqualTo(Test_Saved_item);
		 verify(repository, times(1)).save(Test_item);
	  }
	@Test
	public void getAllTest() {
		when(repository.findAll())
		.thenReturn(Stream.of(new Item(1, "Flour", "InStock", 5), new Item(2, "Eggs", "InStock", 6))
		.collect(Collectors.toList()));
		assertEquals(2, service.getAll().size());
	}


	 @Test
	    void testReadById() {

	        Long id = 1L;
	        Item expected = new Item(id, "Flour", "InStock", 1);

	        Mockito.when(this.repository.findById(id)).thenReturn(Optional.of(expected));

	    assertThat(this.service.readByID(id)).isEqualTo(expected);

	        Mockito.verify(this.repository, Mockito.times(1)).findById(id);
	    }
 

 
 
  @Test
  public void deleteItemTest() {
	  Item item = new Item(1, "Sugar", "Instock", 5);
	  service.delete(item);
  }

  
  @Test
  void testUpdate() {

      // GIVEN
      Long id = 1L;
      Item newValues = new Item(1, "flour", "InStock", 1);
      Item existing = new Item(id, "Butter", "InStock", 2);
      Item updated = new Item(id, newValues.getName(), newValues.getStock(), newValues.getQuantity());

      // WHEN
      Mockito.when(this.repository.findById(id)).thenReturn(Optional.of(existing));
      Mockito.when(this.repository.save(updated)).thenReturn(updated);

      // THEN
      assertThat(this.service.update(newValues)).isEqualTo(updated);

      // verify
      Mockito.verify(this.repository, Mockito.times(1)).findById(id);
      Mockito.verify(this.repository, Mockito.times(1)).save(updated);}
  }
 
