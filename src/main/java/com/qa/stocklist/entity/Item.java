package com.qa.stocklist.entity;

import javax.persistence.Id;
import javax.persistence.Table;


import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;




@Entity
@Table(name = "Items")
@ToString
@NoArgsConstructor

public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String stock;
	
	@Column
	private int quantity;

	public Item(long id, String name, String stock, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(stock, other.stock) && id == other.id && Objects.equals(name, other.name)
				&& quantity == other.quantity;
	}
	
	

}
