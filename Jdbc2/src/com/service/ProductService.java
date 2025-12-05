package com.service;

import java.util.List;

import com.bean.Product;

public interface ProductService {

	boolean addNewProduct();

	List<Product> findAllProducts();

	Product findById(int id);

	boolean modifyProduct(int id, int qty, double price);

	boolean deleteById(int id);

	List<Product> sortProduct();

	void closeMyConnection();

}
