package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn = null;
	static PreparedStatement selproduct;
	static {
		conn = DBUtil.getConnection();
		try {
			selproduct=conn.prepareStatement("select * from product1");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<Product> findAllProducts() {
    List<Product> plist = new ArrayList<>();
    try {
    	ResultSet rs = selproduct.executeQuery();
    	while(rs.next()) {
    		plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
    	}
    	return plist;
    }catch(SQLException e) {
    	e.printStackTrace();
    }
		return null;
	}

}
