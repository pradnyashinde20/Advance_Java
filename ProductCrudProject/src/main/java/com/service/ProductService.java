package com.service;

import java.util.List;

import com.bean.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean addProduct(Product p);

	boolean deleteById(int pid);

	boolean updateProduct(Product p);

	Product findById(int pid);

}
