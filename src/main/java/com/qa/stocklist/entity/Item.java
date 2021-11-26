package com.qa.stocklist.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;




@Entity
@Table(name = "Items")
@ToString
@NoArgsConstructor

public @Data class Item {
	
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
	}}

	