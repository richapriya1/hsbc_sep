package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instagramweb.entity.InstaEmployee;
import com.instagramweb.service.InstagramServiceInterface;
import com.instagramweb.utility.ServiceFactory;

/**
 * Servlet implementation class FriendList
 */
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		System.out.println(name);
		
		InstaEmployee fe=new InstaEmployee();
		fe.setName(name);
		
		InstagramServiceInterface fs=ServiceFactory.createObject("user");
		List<InstaEmployee> i=fs.friendProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(InstaEmployee ff:i) {
				out.println(ff.getName());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}

}
