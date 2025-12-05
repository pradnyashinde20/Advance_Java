package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateInterest extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		double principal=Double.parseDouble(req.getParameter("principal"));
		float rate=Float.parseFloat((req.getParameter("rate")));
		int year=Integer.parseInt(req.getParameter("year"));
		double ans=(principal*rate*year)/100;
		out.println("<h3>interest:"+ans+"<h3>");
		
	}

}
