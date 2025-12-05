package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn = null;
	static PreparedStatement selproduct, insproduct, delproduct,updproduct,searchbyid;
	static {
		conn=DBUtil.getMyConnection();
		try {
			 selproduct=conn.prepareStatement("select * from product1");
			 insproduct = conn.prepareStatement("insert into product1 values(?,?,?,?,?,?)");
			 delproduct = conn.prepareStatement("delete from product1 where pid =?");
			 updproduct = conn.prepareStatement("update product1 set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");
			 searchbyid = conn.prepareStatement("select * from product1 where pid=?");
			 
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAllProducts() {
    List<Product>plist = new ArrayList<>();
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

	@Override
	public boolean save(Product p) {
		try {
			insproduct.setInt(1,p.getPid());
			insproduct.setString(2,p.getPname());
			insproduct.setInt(3, p.getQty());
			insproduct.setDouble(4, p.getPrice());
			insproduct.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insproduct.setInt(6, p.getCid());
			int n= insproduct.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeById(int pid) {
	   try {
		delproduct.setInt(1, pid);
		int n= delproduct.executeUpdate();
		return n>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean modifyProduct(Product p) {
		try {
	   updproduct.setString(1,p.getPname() );
	   updproduct.setInt(2, p.getQty());
	   updproduct.setDouble(3, p.getPrice());
	   updproduct.setDate(4,java.sql.Date.valueOf(p.getExpdate()));
	   updproduct.setInt(5, p.getCid());
	   updproduct.setInt(6, p.getPid());
	   int n = updproduct.executeUpdate();
	   return n>0;
	   
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product searchById(int pid) {
		Product p = new Product();
		try {
			searchbyid.setInt(1, pid);
			ResultSet rs = searchbyid.executeQuery();
			if(rs.next()) {
				return p; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
