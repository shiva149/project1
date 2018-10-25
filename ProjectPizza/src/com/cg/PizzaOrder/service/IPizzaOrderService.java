package com.cg.PizzaOrder.service;

import com.cg.PizzaOrder.bean.Customer;
import com.cg.PizzaOrder.bean.PizzaOrder;
import com.cg.PizzaOrder.exception.PizzaException;

public interface IPizzaOrderService {

	public int placeOrder(Customer customer,PizzaOrder pizza) throws PizzaException;
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException;
}
