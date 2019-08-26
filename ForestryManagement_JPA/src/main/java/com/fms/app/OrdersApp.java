package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Orders;
import com.fms.beans.Product;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidDateException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.OrdersServices;
import com.fms.services.OrdersServicesImpl;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.Validation;

public class OrdersApp {
	public static void ordersApp() {

		Scanner scanner = new Scanner(System.in);
		OrdersServices services = new OrdersServicesImpl();
		CustomerServices customerServices = new CustomerServicesImpl();
		HaulierServices haulierServices = new HaulierServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		Orders orders = null;
		do {
			System.out.println("1. AddOrders");
			System.out.println("2. ModifyOrders");
			System.out.println("3. DeleteOrders");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			int ordersChoice = Integer.parseInt(scanner.next());

			switch(ordersChoice) {
			case 1:
				orders = new Orders();
				System.out.println("Enter the Order Number :");
				String ordersNum = scanner.next();
				while(!Validation.isValidId(ordersNum)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Order Number :");
						ordersNum = scanner.next();
					}
				}
				if(Validation.isValidId(ordersNum))
					orders.setOrderNo(Integer.parseInt(ordersNum));
				System.out.println("Enter the Customer Id :");
				String customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Customer Id :");
						customerId = scanner.next();
					}
				}
				if(Validation.isValidId(customerId)){
					Customer custmr = customerServices.searchCustomer(customerId);
					orders.setCustomer(custmr);
				}
				System.out.println("Enter the Product Id :");
				String productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product Id :");
						productId = scanner.next();
					}
				}
				if(Validation.isValidId(productId)){
					Product prodct = new Product();
					prodct = productServices.searchProduct(Integer.parseInt(productId));
					orders.setProduct(prodct);
				}
				System.out.println("Enter the Haulier Id :");
				String haulierId = scanner.next();
				while(!Validation.isValidId(haulierId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Haulier Id :");
						haulierId = scanner.next();
					}
				}
				if(Validation.isValidId(haulierId)){
					Haulier haulier = new Haulier();
					haulier = haulierServices.searchHaulier(haulierId);
					orders.setHaulier(haulier);
				}
				System.out.println("Enter the Delivery date :");
				String deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)){
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException e){
						System.out.println("Enter the Delivery date :");
						deliveryDate = scanner.next();
					}
				}
				orders.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Quantity :");
				String qty = scanner.next();
				while(!Validation.isValidId(qty))
				{
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Quantity :");
						qty = scanner.next();
					}
				}
				Integer quantity = Integer.parseInt(qty);
				orders.setQuantity(quantity);
				Orders result = services.addOrders(orders);
				if(result != null)
					System.out.println(orders);
				else
					throw new InvalidDataException();
				break;
			case 2:
				orders = new Orders();
				int ordersNumber = 0; 
				System.out.println("Enter the Order Number :");
				ordersNum = scanner.next();
				while(!Validation.isValidId(ordersNum)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Order Number :");
						ordersNum = scanner.next();
					}
				}
				if(Validation.isValidId(ordersNum))
					ordersNumber = Integer.parseInt(ordersNum);
				orders.setOrderNo(ordersNumber);
				System.out.println("Enter the Customer Id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Customer Id :");
						customerId = scanner.next();
					}
				}
				if(Validation.isValidId(customerId)){
					Customer custmr = customerServices.searchCustomer(customerId);
					orders.setCustomer(custmr);
				}
					
					
					
					
					
					
					
				System.out.println("Enter the Product Id :");
				productId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product Id :");
						productId = scanner.next();
					}

				}
				if(Validation.isValidId(productId)){
					Product prodct = new Product();
					prodct = productServices.searchProduct(Integer.parseInt(productId));
					orders.setProduct(prodct);
				}
				
				
				
				
				
				System.out.println("Enter the Haulier Id :");
				haulierId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Haulier Id :");
						haulierId = scanner.next();
					}

				}
				if(Validation.isValidId(haulierId)){
					Haulier haulier = new Haulier();
					haulier = haulierServices.searchHaulier(haulierId);
					orders.setHaulier(haulier);
				}
				System.out.println("Enter the Delivery date :");
				deliveryDate = scanner.next();
				orders.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Quantity :");
				quantity = Integer.parseInt(scanner.next());
				orders.setQuantity(quantity);
				Orders result1 = services.modifyOrders(ordersNumber, orders);
				if(result1 != null)
					System.out.println(orders);
				else
					throw new InvalidDataException();
				break;
			case 3:
				orders = new Orders();
				System.out.println("Enter the Order Number: ");
				String ordersNumb = scanner.next();
				while(!Validation.isValidId(ordersNumb)){
					try{
						throw new InvalidDataException();
					}catch(InvalidDataException e){
						System.out.println("Enter the Order Number: ");
						ordersNumb = scanner.next();
					}
				}
				ordersNumber = Integer.parseInt(ordersNumb);
				Boolean ststus = services.deleteOders(ordersNumber);
				if(ststus)
					System.out.println("Orders deleted");
				else
					throw new InvalidDataException();
				break;
			case 4 : System.exit(0);
				break;
			default:
				break;
			}
		}while(true);

	}
}
