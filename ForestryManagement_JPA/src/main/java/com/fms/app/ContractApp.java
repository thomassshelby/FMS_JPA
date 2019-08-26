package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Contract;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Product;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidDateException;
import com.fms.exceptions.InvalidDayException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.ContractServices;
import com.fms.services.ContractServicesImpl;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.Validation;

public class ContractApp {
	public static void contractApp() {
		ContractServices services = new ContractServicesImpl();
		CustomerServices customerServices = new CustomerServicesImpl();
		HaulierServices haulierServices = new HaulierServicesImpl();
		ProductServices productServices = new ProductServicesImpl();
		
		Scanner scanner = new Scanner(System.in);
		Contract contract = null;
		do {
			System.out.println("1. AddContractor");
			System.out.println("2. DeleteContractor");
//			System.out.println("3. ModifyContract");
		System.out.println("3. Exit");
			System.out.println("Enter your choice");
			int contractChoice = Integer.parseInt(scanner.next());

			switch(contractChoice) {
			case 1:  
				contract = new Contract();
				System.out.println("Enter the Contractor Number :");
				String contractNumber = scanner.next();
				while(!Validation.isValidId(contractNumber)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Contractor Number :");
						contractNumber = scanner.next();
					}
				}
				if(Validation.isValidId(contractNumber)) {
					contract.setContractNo(Integer.parseInt(contractNumber));
				}
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
					contract.setCustomer(custmr);
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
				if(Validation.isValidId(productId)) {
					Product prodct = new Product();
					prodct = productServices.searchProduct(Integer.parseInt(productId));
					contract.setProduct(prodct);
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
					contract.setHaulier(haulier);
				}
			
				System.out.println("Enter the Delivery date :");
				String deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)) {
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException i){
						System.out.println("Enter the Delivery Date :");
						deliveryDate = scanner.next();
					}
				}
				if(Validation.isValidDate(deliveryDate)) {
					contract.setDeliveryDate(deliveryDate);
				}
				System.out.println("Enter the Delivery day :");
				String deliveryDay = scanner.next();
				while(!Validation.isValidDay(deliveryDay)) {
					try{
						throw new InvalidDayException();
					}catch(InvalidDayException i){
						System.out.println("Enter the Delivery Day :");
						deliveryDay = scanner.next();
					}
				}
				if(Validation.isValidDay(deliveryDay)) {
					contract.setDeliveryDay(deliveryDay);
				}
				System.out.println("Enter the Quantity :");
				Integer quantity = Integer.parseInt(scanner.next());
				contract.setQuantity(quantity);
				Contract result = services.addContract(contract);
				if(result!=null)
					System.out.println(contract);
				else
					throw new InvalidDataException();
				break;
			case 2:
				contract = new Contract();
				System.out.println("Enter the Contractor Number :");
				contractNumber = scanner.next();
				while(!Validation.isValidId(contractNumber)) {
					try {
						throw new InvalidIdException();
					} catch (InvalidIdException e) {
						System.out.println("Enter the Contractor Number :");
						contractNumber = scanner.next();
						e.printStackTrace();
					}
				}
				if(Validation.isValidId(contractNumber)) {
					contract.setContractNo(Integer.parseInt(contractNumber));
				}

				Integer contractNumber1  = Integer.parseInt(contractNumber);
				boolean result1 = services.deleteContract(contractNumber1);
				if(result1)
					System.out.println("Contract deleted");
				else
					throw new InvalidDataException();
				break;
			
			default:
				break;
			}
		}while(true);
	}

}
