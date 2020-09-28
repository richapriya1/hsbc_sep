package com.whatsappweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.whatsappweb.entity.WhatsAppUser;

public class WhatsAppDao implements WhatsAppDaoInterface {

	private Connection con;
	public WhatsAppDao() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
		}
		
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int createProfileDAO(WhatsAppUser u) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into whatsapp values(?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getAddress());
			
			//step 4 executeQuery
			i=ps.executeUpdate();
	}
	catch(SQLException ee) {
		ee.printStackTrace();
	}
			return i;
	}

	@Override
	public boolean loginProfile(WhatsAppUser fe) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from whatsapp where name=? and password=?");
			ps.setString(1, fe.getName());
			ps.setString(2, fe.getPassword());
			
			
			//step 4 executeQuery
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}

	@Override
	public List<WhatsAppUser> friendlistdao(WhatsAppUser fe) {
		List<WhatsAppUser> ll=new ArrayList<WhatsAppUser>();
		WhatsAppUser f=new WhatsAppUser();
		f.setName("mohan");
		f.setAddress("Chennai");
		
		WhatsAppUser f1=new WhatsAppUser();
		f1.setName("Chunnilal");
		f1.setAddress("Mumbai");
		
		ll.add(f1);
		ll.add(f);
		
		return ll;
	}

}
