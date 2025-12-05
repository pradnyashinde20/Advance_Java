package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> displayAllProduct();

	Product searchById(int id);

	boolean modify(int id, int qty, double price);

	boolean remove(int id);

	List<Product> sort();

	void close();

}
