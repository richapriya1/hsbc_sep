package com.instagramweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.instagramweb.entity.InstaEmployee;

public class InstagramDAO implements InstagramDAOInterface {

	private Connection con;
	public InstagramDAO() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int createProfile(InstaEmployee fe) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into instatable values(?,?,?,?)");
			ps.setString(1, fe.getName());
			ps.setString(2, fe.getPassword());
			ps.setString(3, fe.getEmail());
			ps.setString(4, fe.getAddress());
			
			//step 4 executeQuery
			i=ps.executeUpdate();
							
			
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}
	@Override
	public boolean loginProfile(InstaEmployee fe) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from instatable where name=? and password=?");
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
	public List<InstaEmployee> friendlistdao(InstaEmployee fe) {
		List<InstaEmployee> ll=new ArrayList<InstaEmployee>();
		InstaEmployee f=new InstaEmployee();
		f.setName("mohan");
		f.setAddress("Chennai");
		
		InstaEmployee f1=new InstaEmployee();
		f1.setName("Chunnilal");
		f1.setAddress("Mumbai");
		
		ll.add(f1);
		ll.add(f);
		return ll;
	}
}
