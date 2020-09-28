package com.instagramweb.service;

import java.util.List;

import com.instagramweb.entity.InstaEmployee;

public interface InstagramServiceInterface {

	int createProfile(InstaEmployee fe);

	boolean loginProfile(InstaEmployee fe);

	List<InstaEmployee> friendProfile(InstaEmployee fe);

}
