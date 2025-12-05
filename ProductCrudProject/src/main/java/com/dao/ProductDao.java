package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDao {

	List<Product> findAllProducts();

	boolean save(Product p);

	boolean removeById(int pid);

	boolean modifyProduct(Product p);

	Product searchById(int pid);

}
