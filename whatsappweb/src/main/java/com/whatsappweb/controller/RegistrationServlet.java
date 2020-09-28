package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whatsappweb.entity.WhatsAppUser;
import com.whatsappweb.service.WhatsAppServiceInterface;
import com.whatsappweb.utility.ServiceFactory;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//retrieve data from client side
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		WhatsAppServiceInterface si=ServiceFactory.createObject("admin");
		WhatsAppUser u=new WhatsAppUser();
		
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setAddress(address);
		
		int i=si.createProfileService(u);
		response.setContentType("text/html");	//Sets the content type of the response being sent to the client
		
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
