package com.cg.PizzaOrder.bean;

public class PizzaOrder {
	private int orderId;
	private int customerId;
	private double totalprice;

	public PizzaOrder(double totalPrice) {
		super();
		this.totalprice=totalPrice;
	}
	
	

	@Override
	public String toString() {
		return "PizzaOrder [orderId="+ orderId + ",customerId=" + customerId + ", totalprice="+ totalprice +"]";
		
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	
}
