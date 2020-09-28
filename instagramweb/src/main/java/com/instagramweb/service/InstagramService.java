package com.instagramweb.service;

import java.util.List;

import com.instagramweb.dao.InstagramDAOInterface;
import com.instagramweb.entity.InstaEmployee;
import com.instagramweb.utility.DAOFactory;

public class InstagramService implements InstagramServiceInterface{

	
private InstagramDAOInterface fd;
	
	public InstagramService() {
		fd=DAOFactory.createObject("user");
	}

	
	@Override
	public int createProfile(InstaEmployee fe) {
		return fd.createProfile(fe);
	}

	@Override
	public boolean loginProfile(InstaEmployee fe) {
		// TODO Auto-generated method stub
		return fd.loginProfile(fe);
	}

	@Override
	public List<InstaEmployee> friendProfile(InstaEmployee fe) {
		return fd.friendlistdao(fe);
	}

}
