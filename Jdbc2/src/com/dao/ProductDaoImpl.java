package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn;
     static PreparedStatement insProd, findall, findById,modify,remove,sort;
     static {
     try {
    	 conn=DBUtil.getConnection();
    	 insProd = conn.prepareStatement("insert into myproduct values(?,?,?,?,?)");
    	 findall = conn.prepareStatement("select * from myproduct");
    	 findById = conn.prepareStatement("select * from myproduct where id =?");
    	 modify=conn.prepareStatement("update myproduct set qty=?,price=? where id=?");
    	 remove=conn.prepareStatement("delete from myproduct where id=?");
    	 sort=conn.prepareStatement("select * from myproduct order by price desc");
     }catch(SQLException e) {
    	 System.out.println(e.getMessage());
    	 e.printStackTrace();
     }
    }
	@Override
	public boolean save(Product p) {
		try {
		insProd.setInt(1, p.getPid());
		insProd.setString(2,p.getPname());
		insProd.setInt(3, p.getQty());
		insProd.setDouble(4, p.getPrice());
		insProd.setDate(5, java.sql.Date.valueOf(p.getDate()));
		int n = insProd.executeUpdate();
		return n>0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public List<Product> displayAllProduct() {
		List<Product>plist = new ArrayList<>();
		try {
			ResultSet rs = findall.executeQuery();
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}else {
					plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
		}else {
			return null;
		}
		
	}
	@Override
	public Product searchById(int id) {
		Product p = null;
		try {
			findById.setInt(1, id);
			ResultSet rs =findById.executeQuery();
			if(rs.next()) {
				if(rs.getDate(5)!=null) {
					p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
				}else {
					p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public boolean modify(int id, int qty, double price) {
		// TODO Auto-generated method stub
		try {
		modify.setInt(1,qty);
		modify.setDouble(2,price);
		modify.setInt(3, id);
		
			int n=modify.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		try {
			remove.setInt(1, id);
		
		int n=remove.executeUpdate();
		if(n>0)
		{
		return true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Product> sort() {
		List<Product>li=new ArrayList<>();
		try {
		ResultSet rs=sort.executeQuery();
		while(rs.next())
		{
			if(rs.getDate(5)!=null)
			{
				li.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
			}
			else {
				li.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
			}
		}}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public void close() {
		
		 DBUtil.closeMyConnection();;
	}
}