package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookiesDemo")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String name=request.getParameter("nm");
	String button=request.getParameter("btn");
	switch(button)
	{
	case "add"->{
		String val=request.getParameter("val");
		Cookie c=new Cookie(name,val);
	response.addCookie(c);
	out.println("<h1>cookies added successfully</h2>");
	}
	case "delete"->{
		Cookie[] arr=request.getCookies();
		for(Cookie c:arr)
		{
			if(c.getName().equals(name))
			{
				c.setMaxAge(0);
				response.addCookie(c);
				out.println("<h2>cookie deleted"+name+"</h2>");
			}
		}
	}
	case "display"->{
		Cookie[] arr=request.getCookies();
		for(Cookie c:arr)
		{
			out.println("name"+c.getName()+"------>"+"value"+c.getValue());
			
		}
	}
	}
	RequestDispatcher rd=request.getRequestDispatcher("cookies.html");
	rd.include(request, response);
	
	}

}
