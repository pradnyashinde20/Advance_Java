package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;
import com.demo.servlet.ProductServlet;

public interface ProductDao {

	List<Integer> findAllCategory();

	List<Product> findByCategory(int cid);



}
