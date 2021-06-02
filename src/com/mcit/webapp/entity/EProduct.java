package com.mcit.webapp.entity;

import java.util.Date;

public class EProduct {
	
	//properties
	private int id;
	private String name;
	private Double price;
	private Date createdAt;
	private Date modifiedAt;
	
	
	public EProduct() {}
	
	public EProduct(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	}

	public EProduct(int id, String name, Double price, Date createdAt, Date modifiedAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	// get & set methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
