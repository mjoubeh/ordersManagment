package com.souq.bean;

public class ItemBean {

	private long id;
	private String status;
	private int quantity;
	private double price;

	@Override
	public String toString() {
		return "ItemBean [id=" + id + ", status=" + status + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
