package com.binaryvibes.auto.parts.store.rest.api;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Aamir Muhammad
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 951216329277503635L;

	private String orderId;
	private String autoPartId;
	private int quantity;
	private double total;
	
	public Order() {
		this.orderId = UUID.randomUUID().toString();
	}
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the autoPartId
	 */
	public String getAutoPartId() {
		return autoPartId;
	}
	/**
	 * @param autoPartId the autoPartId to set
	 */
	public void setAutoPartId(String autoPartId) {
		this.autoPartId = autoPartId;
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
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
}
