package com.fms.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.fms.beans.Address;
import com.fms.beans.Customer;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidEmailException;
import com.fms.exceptions.InvalidIdException;
import com.fms.exceptions.InvalidNameException;
import com.fms.exceptions.InvalidPasswordException;
import com.fms.exceptions.InvalidPostCodeException;
import com.fms.exceptions.InvalidTelNoException;
import com.fms.exceptions.InvalidTownCityException;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.Validation;

public class CustomerApp {

	public static void customerApp() throws IOException {

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Create Customer");
			System.out.println("2. Modify Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");
			System.out.println("Enter choice");
			int custChoice = Integer.parseInt(scanner.next());
			CustomerServices db = new CustomerServicesImpl();
			Customer customer = null;
			Address address =  new Address();
			switch(custChoice) {
			case 1: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				String customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}
				customer.setCustomerId(customerId);
				System.out.println("Enter customer Name :");
				DataInputStream object = new DataInputStream(System.in);
				String  customerName = object.readLine();
				while(!Validation.isValidName(customerName)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Customer Name :");
						customerName = scanner.next();

					}
				}
				customer.setCustomerName(customerName);
				System.out.println("Enter Street Address 1 :");
				String streetAddress1=scanner.next();
				address.setStreetAddress1(streetAddress1);
				System.out.println("Enter the Streeet Address 2 :");
				String streetAddress2=scanner.next();
				address.setStreetAddress2(streetAddress2);
				System.out.println("Enter the Town City :");
				String townCity=scanner.next();
				boolean isValidtownCity = Validation.isValidtownCity(townCity);
				while(!isValidtownCity) {
					try{
						throw new InvalidTownCityException();
					}catch(InvalidTownCityException e){
						System.out.println("Enter the town city :");
						townCity=scanner.next();
					}
				}
				address.setTownCity(townCity);
				System.out.println("Enter Post Code :");
				String postCode=scanner.next();
				while(!Validation.isValidPostCode(postCode)) {
					try{
						throw new InvalidPostCodeException();
					}catch(InvalidPostCodeException i){
						System.out.println("Enter Post Code :");
						postCode = scanner.next();
					}
				}
				address.setPostCode(postCode);
				customer.setAddress(address);
				System.out.println("Enter Telephone number :");
				Long telephoneNumber = scanner.nextLong();
				boolean isValidTelNum = Validation.isValidTelNum(telephoneNumber);
				while(!isValidTelNum) {
					try{
						throw new InvalidTelNoException();
					}catch(InvalidTelNoException i){
						System.out.println("Enter Telephone number :");
						telephoneNumber = scanner.nextLong();
					}


				}
				customer.setTelephoneNumber(telephoneNumber);
				System.out.println("Enter the Email :");
				String email=scanner.next();
				boolean isValidEmail = Validation.isEmailValid(email);
				while(!isValidEmail) {
					try{
						throw new InvalidEmailException();
					}catch(InvalidEmailException e){
						System.out.println("Enter the Email :");
						email=scanner.next();
					}
				}
				customer.setEmailAddress(email);
				System.out.println("Enter Customer password :");
				String password = scanner.next();
				boolean isValidPassword  = Validation.isValidPassword(password);
				while(!isValidPassword) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password = scanner.next();
					}
				}
				customer.setCustomerPassword(password);
				Customer result = db.addCustomer(customer,address);

				if(result!=null){
					System.out.println(result);
				}
				else{
					throw new InvalidDataException();
				}
				break;
			case 2: 
				customer = new Customer(); 
				System.out.println("Enter Customer id :");
				String customerId1 = scanner.next();
				while(!Validation.isValidId(customerId1)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId1 = scanner.next();
					}
				}
				customer.setCustomerId(customerId1);
				System.out.println("Enter Customer Password");
				String passwd = scanner.next();
				System.out.println("Enter customer Name :");
				String customerName1 = scanner.next();
				while(!Validation.isValidName(customerName1)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Customer Name :");
						customerName1 = scanner.nextLine();
					}
				}
				customer.setCustomerName(customerName1);
				System.out.println("Enter Street Address 1 :");
				String streetAddress11=scanner.next();
				address.setStreetAddress1(streetAddress11);
				System.out.println("Enter the Streeet Address 2 :");
				String streetAddress21=scanner.next();
				address.setStreetAddress2(streetAddress21);
				System.out.println("Enter the Town City :");
				String townCity1=scanner.next();
				address.setTownCity(townCity1);
				System.out.println("Enter Post Code :");
				String postCode1=scanner.next();
				while(!Validation.isValidPostCode(postCode1)) {
					try{
						throw new InvalidPostCodeException();
					}catch(InvalidPostCodeException i){
						System.out.println("Enter Post Code :");
						postCode1 = scanner.next();
					}
				}
				address.setPostCode(postCode1);
				customer.setAddress(address);
				System.out.println("Enter Telephone number :");
				telephoneNumber = scanner.nextLong();
				while(!Validation.isValidTelNum(telephoneNumber)) {
					try{
						throw new InvalidTelNoException();
					}catch(InvalidTelNoException i){
						System.out.println("Enter Telephone number :");
						telephoneNumber = scanner.nextLong();
					}


				}
				customer.setTelephoneNumber(telephoneNumber);
				System.out.println("Enter the Email :");
				String email1=scanner.next();
				while(! Validation.isEmailValid(email1)) {
					try{
						throw new InvalidEmailException();
					}catch(InvalidEmailException e){
						System.out.println("Enter the Email :");
						email1=scanner.next();
					}
				}
				customer.setEmailAddress(email1);
				System.out.println("Enter Customer password :");
				String password1 = scanner.next();
				while(!Validation.isValidPassword(password1)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password1 = scanner.next();
					}
				}
				customer.setCustomerPassword(password1);
				result = db.modifyCustomer(customer, passwd,address);
				if(result!=null)
					System.out.println(customer);
				else
					throw new InvalidDataException();
				break;
			case 3: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}
				customer = db.searchCustomer(customerId);
				if(customer != null) {
					System.out.println(customer);
				}else{
					while(customer == null){
						try{
							throw new InvalidDataException();
						}catch(InvalidDataException i){
							customerId = scanner.next();
							while(!Validation.isValidId(customerId)) {
								try{
									throw new InvalidIdException();
								}catch(InvalidIdException x){
									System.out.println("Enter Customer id :");
									customerId = scanner.next();
								}
							}
							customer = db.searchCustomer(customerId);
						}
					}
				}
				break;
			case 4: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}

				System.out.println("Enter Customer password :");
				password = scanner.next();
				isValidPassword  = Validation.isValidPassword(password);
				while(!isValidPassword) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password = scanner.next();
					}
				}
				Boolean state = db.deleteCustomer(customerId, password);
				while (!state)
				{
					try{
						throw new InvalidDataException();
					}catch(InvalidDataException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
						while(!Validation.isValidId(customerId)) {
							try{
								throw new InvalidIdException();
							}catch(InvalidIdException f){
								System.out.println("Enter Customer id :");
								customerId = scanner.next();
							}
						}

						System.out.println("Enter Customer password :");
						password = scanner.next();
						isValidPassword  = Validation.isValidPassword(password);
						while(!isValidPassword) {
							try{
								throw new InvalidPasswordException();
							}catch(InvalidPasswordException e)
							{
								System.out.println("Enter Customer password :");
								password = scanner.next();
							}
						}
						state = db.deleteCustomer(customerId, password);

					}
				}
				System.out.println("Profile Deleted");
				break;
			default:
				System.out.println("Enter the correct choice");
				break;
			}
		}while(true);

	}

}

