package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class UpdateProduct extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int qty=Integer.parseInt(request.getParameter("qty"));
		double price=Double.parseDouble(request.getParameter("price"));
		String dt=request.getParameter("expdate");
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		Product p = new Product(pid,pname,qty,price,ldt,cid);
		
		ProductService pservice = new ProductServiceImpl();
		boolean status = pservice.updateProduct(p);
		RequestDispatcher rd = request.getRequestDispatcher("showproduct");
		rd.forward(request, response);
	}

}
