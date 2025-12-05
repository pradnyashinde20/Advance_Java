package com.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;
	
	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}

	@Override
	public boolean addNewProduct() {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter product id");
	int id = sc.nextInt();
	System.out.println("enter product name");
	String name = sc.next();
	System.out.println("enter product quantity");
	int qty = sc.nextInt();
	System.out.println("enter product price");
	double price = sc.nextDouble();
	System.out.println("enter date");
	String dt = sc.next();
	LocalDate dtl = LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	Product p = new Product(id,name,qty,price,dtl);
	
		return pdao.save(p);
	}

	@Override
	public List<Product> findAllProducts() {
		
		return pdao.displayAllProduct();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return pdao.searchById(id);
	}

	@Override
	public boolean modifyProduct(int id, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.modify(id,qty,price);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return pdao.remove(id);
	}

	@Override
	public List<Product> sortProduct() {
		// TODO Auto-generated method stub
		return pdao.sort();
	}

	@Override
	public void closeMyConnection() {
		 pdao.close();
		
	}

}
