package com.souq.bean;

public class OrderBean {

	private long orderId;
	private String orderName;
	private double grandTotal;

	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", customerName=" + orderName + ", grandTotal=" + grandTotal + "]";
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
