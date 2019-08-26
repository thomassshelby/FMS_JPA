package com.fms.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.fms.beans.Address;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Haulier;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidEmailException;
import com.fms.exceptions.InvalidIdException;
import com.fms.exceptions.InvalidNameException;
import com.fms.exceptions.InvalidPasswordException;
import com.fms.exceptions.InvalidPostCodeException;
import com.fms.exceptions.InvalidTelNoException;
import com.fms.exceptions.InvalidTownCityException;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.Validation;

public class HaulierApp {
	public static void haulierApp() throws IOException {

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Create Haulier");
			System.out.println("2. Delete Haulier");
			System.out.println("3. Search Haulier");
			System.out.println("4. Modify Haulier");
			System.out.println("5. Exit");
			System.out.println("Enter choice");
			int custChoice = Integer.parseInt(scanner.next());
			HaulierServices services = new HaulierServicesImpl();
			Haulier haulier = null;
			Address address = new Address();
			switch(custChoice) {
			case 1: 
				haulier = new Haulier();
				System.out.println("Enter Haulier id :");
				String haulierId = scanner.next();
				while(!Validation.isValidId(haulierId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Haulier id :");
						haulierId = scanner.next();
					}
				}
				haulier.setHaulierId(haulierId);
				System.out.println("Enter Haulier Name :");
				DataInputStream object = new DataInputStream(System.in);
				String  haulierName = object.readLine();
				while(!Validation.isValidName(haulierName)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Haulier Name :");
						haulierName = scanner.next();

					}
				}
				haulier.setHaulierName(haulierName);
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
				haulier.setAddress(address);
				while(!Validation.isValidPostCode(postCode)) {
					try{
						throw new InvalidPostCodeException();
					}catch(InvalidPostCodeException i){
						System.out.println("Enter Post Code :");
						postCode = scanner.next();
					}
				}
				address.setPostCode(postCode);
				haulier.setAddress(address);
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
				haulier.setTelephoneNumber(telephoneNumber);
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
				haulier.setEmailAddress(email);
				System.out.println("Enter Haulier password :");
				String haulierPassword = scanner.next();
				boolean isValidPassword  = Validation.isValidPassword(haulierPassword);
				while(!isValidPassword) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Haulier password :");
						haulierPassword = scanner.next();
					}
				}
				haulier.setHaulierPassword(haulierPassword);
				Haulier result = services.addHaulier(haulier,address);
				if(result!=null){
					System.out.println(result);
				}
				else{
					throw new InvalidDataException();
				}

				break;
			case 2:
				haulier = new Haulier();
				System.out.println("Enter Haulier id :");
				haulierId = scanner.next();
				while(!Validation.isValidId(haulierId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Haulier id :");
						haulierId = scanner.next();
					}
				}

				System.out.println("Enter Haulier password :");
				haulierPassword = scanner.next();
				isValidPassword  = Validation.isValidPassword(haulierPassword);
				while(!isValidPassword) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Haulier password :");
						haulierPassword = scanner.next();
					}
				}
				Boolean state = services.deleteHaulier(haulierId, haulierPassword);
				while (!state)
				{
					try{
						throw new InvalidDataException();
					}catch(InvalidDataException i){
						System.out.println("Enter Haulier id :");
						haulierId = scanner.next();
						while(!Validation.isValidId(haulierId)) {
							try{
								throw new InvalidIdException();
							}catch(InvalidIdException f){
								System.out.println("Enter Haulier id :");
								haulierId = scanner.next();
							}
						}

						System.out.println("Enter Haulier password :");
						haulierPassword = scanner.next();
						isValidPassword  = Validation.isValidPassword(haulierPassword);
						while(!isValidPassword) {
							try{
								throw new InvalidPasswordException();
							}catch(InvalidPasswordException e)
							{
								System.out.println("Enter Haulier password :");
								haulierPassword = scanner.next();
							}
						}
						state = services.deleteHaulier(haulierId, haulierPassword);

					}
				}
				System.out.println("Profile Deleted");
				break;
			case 3:
				haulier = new Haulier();
				System.out.println("Enter Haulier id :");
				haulierId = scanner.next();
				while(!Validation.isValidId(haulierId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Haulier id :");
						haulierId = scanner.next();
					}
				}
				haulier = services.searchHaulier(haulierId);
				if(haulier != null) {
					System.out.println(haulier);
				}else{
					while(haulier == null){
						try{
							throw new InvalidDataException();
						}catch(InvalidDataException i){
							haulierId = scanner.next();
							while(!Validation.isValidId(haulierId)) {
								try{
									throw new InvalidIdException();
								}catch(InvalidIdException x){
									System.out.println("Enter Haulier id :");
									haulierId = scanner.next();
								}
							}
							haulier = services.searchHaulier(haulierId);
						}
					}
				}
				break;
			case 4:
				haulier = new Haulier(); 
				System.out.println("Enter Haulier id :");
				String haulierId1 = scanner.next();
				while(!Validation.isValidId(haulierId1)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						haulierId1 = scanner.next();
					}
				}
				haulier.setHaulierId(haulierId1);;
				System.out.println("Enter Haulier Password");
				String passwd = scanner.next();
				System.out.println("Enter Haulier Name :");
				String haulierName1 = scanner.next();
				while(!Validation.isValidName(haulierName1)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Haulier Name :");
						haulierName1 = scanner.nextLine();
					}
				}
				haulier.setHaulierName(haulierName1);
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
				haulier.setAddress(address);
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
				haulier.setTelephoneNumber(telephoneNumber);
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
				haulier.setEmailAddress(email1);
				System.out.println("Enter Haulier password :");
				String password1 = scanner.next();
				while(!Validation.isValidPassword(password1)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Haulier password :");
						password1 = scanner.next();
					}
				}
				haulier.setHaulierPassword(password1);
				result = services.modifyHaulier(haulier, passwd, address);
				if(result!=null)
					System.out.println(haulier);
				else
					throw new InvalidDataException();
				break;
			default:
				System.out.println("Enter the correct choice");
				break;
			}

		}while(true);

	}
}