package com.fms.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;
import com.fms.beans.Product;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.Validation;

public class ProductApp { 

	public static void productApp() throws IOException {
		ProductServices services = new ProductServicesImpl();

		Product product = null;
		do {
			System.out.println("1. AddProduct");
			System.out.println("2. ModifyProduct");
			System.out.println("3. DeleteProduct");
			System.out.println("4. SearchProduct");
			System.out.println("5. Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your choice");
			int productChoice = Integer.parseInt(scanner.next());

			switch (productChoice){
			case 1:
				product = new Product();
				System.out.println("Enter the Product id :");
				String productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}
				}
				product.setProductId(Integer.parseInt(productId));
				System.out.println("Enter the Product Name :");
				String productName = scanner.next();
				while(!Validation.isValidName(productName))
				{
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product Name :");
						productName = scanner.next();
					}
				}
				product.setProductName(productName);
				System.out.println("Enter the Product Description :");
				DataInputStream object = new DataInputStream(System.in);
				String productDescription = object.readLine();
				product.setProductDescription(productDescription);
				Product result = services.addProduct(product);
				if(result != null)
					System.out.println(product);
				else
					throw new InvalidDataException();
				break;
			case 2:
				product = new Product();
				int productID = 0;
				System.out.println("Enter the Product id :");
				productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();

					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}
				}
				if(Validation.isValidId(productId))
					productID = Integer.parseInt(productId);
				System.out.println("Enter the Product Name :");
				productName = scanner.next();
				while(!Validation.isValidName(productName)){
					try{
						throw new InvalidDataException();
					}catch(InvalidDataException e){
						System.out.println("Enter the Product Name :");
						productName = scanner.next();
					}
				}
				product.setProductName(productName);
				System.out.println("Enter the Product Description :");
				object = new DataInputStream(System.in);
				productDescription = object.readLine();
				product.setProductDescription(productDescription);
				result = services.modifyProduct(productID, product);
				product.setProductId(Integer.parseInt(productId));
				if(result != null) 
					System.out.println(product);
				else
					throw new InvalidDataException();
				break;
			case 3:
				product = new Product();
				productID = 0;
				System.out.println("Enter the Product id :");
				productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}

				}
				if(Validation.isValidId(productId))
					productID = Integer.parseInt(productId);
				Boolean result1 = services.deleteProduct(productID);
				if(result1)
					System.out.println("Product details deleted");
				else
					throw new InvalidDataException();
				break;

			case 4:
				Product searchProduct = new Product();
				productID = 0;
				System.out.println("Enter the Product id :");
				productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}

				}
				if(Validation.isValidId(productId))
					productID = Integer.parseInt(productId);
				Product resproduct = services.searchProduct(productID);
				if(product!=null)
				System.out.println(resproduct);
				else
					throw new InvalidDataException();
			default:
				System.exit(0);
				break;
			}
		}while(true);
	}
}