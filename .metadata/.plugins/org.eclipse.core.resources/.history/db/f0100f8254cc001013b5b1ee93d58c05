package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.beans.Product;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession();
	MyUser user=(MyUser)session.getAttribute("user");
	if(user!=null&&user.getRole().equals("user"))
	{
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
		int ord_Qty=Integer.parseInt(request.getParameter("qty"));
		Set<Product> cart=(Set<Product>)session.getAttribute("cart");
		if(cart==null)
		{
			cart=new HashSet<>();
		}
		Product p=new Product(pid,pname,ord_Qty,price,null,0);
		boolean status=cart.add(p);
		session.setAttribute("cart",cart);
		cart.stream().forEach(System.out::println);
		RequestDispatcher rd=request.getRequestDispatcher("/ShowProductServlet");
		rd.forward(request,response);
	}else {
		out.println("<h2>invalid credential</h2>");
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request,response);
		
	}

}
}
