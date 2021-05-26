package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the choice");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Find All Products");
					productSet = service.findAll();
					System.out.println(productSet);
					break;
				case 2:
					System.out.println("Find the Product By Id");
					System.out.println("Enter the Product Id");
					id = scanner.nextInt();
					try {
						Product product = service.findById(id);
						System.out.println(product);
					} catch (ProductNotFoundException e) {
					}
					break;
				case 3:
					System.out.println("Update the Product Name Based on the Id");
					date = "06/06/2021";
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					Product updateProduct = new Product(3, "Apple", LocalDate.parse(date, dateFormat));
					try {
						service.update(updateProduct);
						productSet = service.findAll();
						System.out.println(productSet);
					} catch (ProductNotFoundException e) {
		
					}
					break;
				case 4:
					System.out.println("Adding a Product");
					date = "06/12/2021";
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					Product newProduct = new Product(4, "AppleJuice", LocalDate.parse(date, dateFormat));
					service.save(newProduct);
					productSet = service.findAll();
					System.out.println(productSet);
					break;
				case 5:
					System.out.println("Deleting a Product");
					System.out.println("Enter the Product Id");
					id = scanner.nextInt();
					try {
						service.delete(id);
						productSet = service.findAll();
						System.out.println(productSet);
					} catch (ProductNotFoundException e) {
					}
				case 6:
					System.out.println("Finding product by name");
					name = scanner.next();
					try {
						Product product = service.findByName(name);
						System.out.println(product);
					}
					catch(ProductNotFoundException e) {
					}
				case 7:
					System.out.println("Update the expiry date by id");
					id = scanner.nextInt();
					date = "10/08/2021";
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					Product updatedate = new Product(id, "Apple", LocalDate.parse(date, dateFormat));
					try {
						service.updateExpire(updatedate);
						productSet = service.findAll();
						System.out.println(productSet);
					} catch (ProductNotFoundException e) {
		
					}
				default:
					System.exit(0);
					break;
			}
		}
		
	}
	
  }

