package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class FindById extends HttpServlet{
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  ProductService pservice = new ProductServiceImpl();
  int pid = Integer.parseInt(request.getParameter("pid"));
  Product p = pservice.findById(pid);
  if(p!=null) {
	  out.println(p);
  }else {
	  out.println("not found");
  }


  
 }
}
