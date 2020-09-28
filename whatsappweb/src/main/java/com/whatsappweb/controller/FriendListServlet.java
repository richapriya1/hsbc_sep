package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whatsappweb.entity.WhatsAppUser;
import com.whatsappweb.service.WhatsAppServiceInterface;
import com.whatsappweb.utility.ServiceFactory;


/**
 * Servlet implementation class FriendListServlet
 */
public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		System.out.println(name);
		
		WhatsAppUser fe=new WhatsAppUser();
		fe.setName(name);
		
		WhatsAppServiceInterface fs=ServiceFactory.createObject("adminservice");
		List<WhatsAppUser> i=fs.friendProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(WhatsAppUser ff:i) {
				out.println(ff.getName());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}

}
