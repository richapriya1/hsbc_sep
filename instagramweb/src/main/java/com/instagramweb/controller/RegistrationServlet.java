package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instagramweb.entity.InstaEmployee;
import com.instagramweb.service.InstagramServiceInterface;
import com.instagramweb.utility.ServiceFactory;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		InstaEmployee fe=new InstaEmployee();
		fe.setName(name);
		fe.setAddress(address);
		fe.setEmail(email);
		fe.setPassword(password);
		
		
		
		InstagramServiceInterface fs=ServiceFactory.createObject("user");
		int i=fs.createProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i>0) {
			
			out.println("Registration successful   <a href=login.html>Continue...</a>");
				
			out.println("Your Name is "+name);
			out.println("<br>Your Password is "+password);
			
		}
		out.println("</body></html>");
	}

}
