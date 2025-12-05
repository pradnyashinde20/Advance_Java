package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ShowProduct extends HttpServlet{
 public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 ProductService pservice= new ProductServiceImpl();
	 List<Product> plist=pservice.getAllProducts();
	 out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>Qty</th><th>Price</th><th>ExpDate</th><th>Cid</th><th>Action</th></tr>");
	 for(Product p:plist) {
		 out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getExpdate()+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='deleteproduct?pid="+p.getPid()+"'>delete</a>/<a href='editproduct?pid="+p.getPid()+"'>edit</a></td></tr>");
	 }
	 out.println("</table>");
	 out.println("<a href='addProduct.html'> Add New Product </a>");
 }
 public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		doPost(req,resp);
	}
}
