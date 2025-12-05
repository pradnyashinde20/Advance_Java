package com.test;

import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class TestProduct {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int choice=0;
	ProductService pservice=new ProductServiceImpl();
	do {
		System.out.println("1.add new product\n2.display all products\n3.modify product");
		System.out.println("4.find by id\n5.delete\n6.display in sorted order\n7.exit");
		System.out.println("Choice :");
		choice = sc.nextInt();
		switch(choice) {
		case 1->{
			boolean status = pservice. addNewProduct();
			if(status) {
				System.out.println("product details added successfully");
			}else {
				System.out.println("not added");
			}
		}
		
		case 2->{
			List<Product> plist = pservice.findAllProducts();
		    plist.forEach(System.out::println);
		}
		case 3->{
			System.out.println("enter the id:");
			int id=sc.nextInt();
			System.out.println("enter the qty:");
			int qty=sc.nextInt();
			System.out.println("enter the price:");
			double price=sc.nextDouble();
			boolean status=pservice.modifyProduct(id,qty,price);
			if(status)
			{
				System.out.println("update succesfully");
			}
			else {
				System.out.println("error");
			}
			
		}
		
		case 4->{
			System.out.println("enter id");
			int id = sc.nextInt();
		  Product p = pservice.findById(id);
		  if(p==null) {
			  System.out.println("not found");
		  }else {
		  System.out.println(p);
		  }
		}
		case 5->{
			System.out.println("enter the id to delete:");
			int id=sc.nextInt();
			boolean status=pservice.deleteById(id);
			if(status)
			{
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("not found");
			}
		}
		case 6->{
			List<Product>li=pservice.sortProduct();
			li.forEach(System.out::println);
		}
		case 7->{
			System.out.println("thank you for visiting!!");
			sc.close();
			pservice.closeMyConnection();
		}
		}
		
	}while(choice!=7);
}
}
