package com.binaryvibes.auto.parts.store.rest.api;

import java.io.Serializable;

/**
 * File: AutoPart.java
 * 
 * @author Aamir Muhammad
 *
 */
public class AutoPart implements Serializable {
	
	private static final long serialVersionUID = -4013597982342031027L;
	
	private String id;
	private String name;
	private int quantity;
	private double price;
	
	public AutoPart() {}
	
	public AutoPart(String id, String name, int quantity, float price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
