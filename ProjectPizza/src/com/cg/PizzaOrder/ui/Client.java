package com.cg.PizzaOrder.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.PizzaOrder.bean.Customer;
import com.cg.PizzaOrder.bean.PizzaOrder;
import com.cg.PizzaOrder.exception.PizzaException;
import com.cg.PizzaOrder.service.IPizzaOrderService;
import com.cg.PizzaOrder.service.PizzaOrderService;



public class Client {
public static void main(String[] args) throws PizzaException {
	
	IPizzaOrderService service;
	{
		service = new PizzaOrderService();
	}
	double basePizzaPrice=350;
	double pizzaToppingsPrice=0;
	double totalPrice=0;
	LocalDate date=null;
int orderId=0;
Scanner sc = new Scanner(System.in);
sc.useDelimiter("\n");

String choice;
String ans;
do {
	System.out.println("1. Place Order");
	System.out.println("2. Display Order");
	System.out.println("3. Exit");
	
	System.out.println(" Enter your CHoice");
	choice=sc.nextLine();
	switch (choice) {
	case "1":
		System.out.println("Enter the name of the customer");
		String custName = sc.nextLine();
		System.out.println("Enter the address of the customer");
		String address=sc.nextLine();
		System.out.println("Enter the mobile No. of the customer");
		String phone=sc.nextLine();
		System.out.println("Enter the Pizza Topping preffered");
		String topping=sc.nextLine();
		switch (topping) {
		case "Capsicum":
			pizzaToppingsPrice=30;
			break;
		case "MushRoom":
			pizzaToppingsPrice=50;
			break;
		case "Jalapeno":
			pizzaToppingsPrice=70;
			break;
	
		case "Paneer":
			pizzaToppingsPrice=85;
			break;
			default:
				System.out.println("Preffered Pizza Toppings are Invalid");
		}
		totalPrice=basePizzaPrice +pizzaToppingsPrice;
		System.out.println("Price:(To be calculated :Rs "+ (int)basePizzaPrice + " + " + (int)pizzaToppingsPrice + "("
				+ topping + ")=" + (int)totalPrice);
		System.out.println("Order Date: "+ date.now());
		Customer customer = new Customer( custName ,address, phone);
		PizzaOrder pizza =new PizzaOrder(totalPrice);
		orderId=service.placeOrder(customer,pizza);
		if(orderId !=0) {
			System.out.println("Pizza Order Succesfully placed with Order Id: " +orderId);
		}
		break;
	case "2":
		
	System.out.println("Enter your orderId");
	orderId=Integer.parseInt(sc.nextLine());
	PizzaOrder pizzaOrder =service.getOrderDetails(orderId);
	if(pizzaOrder !=null) {
		System.out.println("OrderID\tCustomerID\tTotal Price");
		System.out.println(pizzaOrder.getOrderId()+ "\t" + pizzaOrder.getCustomerId() + "\t\t"
		+(int)pizzaOrder.getTotalprice());
		
	}
	break;
	case "3":
		System.exit(0);
		break;
		default:
			System.out.println("Invalid Choice");
	}
	System.out.println("Do you wish to continue? yes/no");
	ans=sc.nextLine();
}
while(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y"));
sc.close();
	
	
		}
	}


