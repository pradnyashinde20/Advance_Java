package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MyUser;
import com.service.LoginService;
import com.service.LoginServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException {
    	   resp.setContentType("text/html");
    	   		PrintWriter out=resp.getWriter();
    	   		String uname=req.getParameter("uname");
    	   		String upass=req.getParameter("upass");
    	   		LoginService ls=new LoginServiceImpl();
    	   		MyUser user=ls.validateUser(uname,upass);
    	   if(user!=null)
    	   {
    		   RequestDispatcher rd=req.getRequestDispatcher("/ShowProduct");
    		   rd.forward(req, resp);
    	   }else {
    		   out.println("invalid credentials");
    		   RequestDispatcher rd=req.getRequestDispatcher("Login.html");
    		   rd.include(req, resp);
    		   
    	   }
       }
    
	

}
