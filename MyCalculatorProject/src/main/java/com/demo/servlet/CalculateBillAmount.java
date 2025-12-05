package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateBillAmount extends HttpServlet{
	double rate1,rate2,rate3;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		System.out.println("servlet init method");
		rate1=Double.parseDouble(config.getInitParameter("rate1"));
		rate2=Double.parseDouble(config.getInitParameter("rate2"));
		rate3=Double.parseDouble(config.getInitParameter("rate3"));
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException
	{
		resp.setContentType("test/html");
		PrintWriter out=resp.getWriter();
		double units=Double.parseDouble(req.getParameter("units"));
		double billamt=0;
		if(units>100)
		{
			billamt=100*rate1;
		}else {
			billamt=units*rate1;
		}
		if(units>101)
		{
			double rununits=units-100;
			if(rununits>500)
			{
				billamt=billamt+(500*rate2)+(rununits-500)*rate3;
			}else {
				billamt=billamt+(rununits*rate2);
			}
		}
		out.println("billamount:"+billamt);
	}

}
