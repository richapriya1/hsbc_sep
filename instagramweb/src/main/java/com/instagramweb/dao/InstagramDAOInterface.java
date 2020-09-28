package com.instagramweb.dao;

import java.util.List;

import com.instagramweb.entity.InstaEmployee;

public interface InstagramDAOInterface {

	int createProfile(InstaEmployee fe);

	boolean loginProfile(InstaEmployee fe);

	List<InstaEmployee> friendlistdao(InstaEmployee fe);

}
