package com.service;

import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
 private ProductDao pdao;
 public ProductServiceImpl() {
	 pdao=new ProductDaoImpl();
 }
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAllProducts();
	}
	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.save(p);
	}
	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pdao.removeById(pid);
	}
	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.modifyProduct(p);
	}
	@Override
	public Product findById(int pid) {
	
		return pdao.searchById(pid);
	}

}
