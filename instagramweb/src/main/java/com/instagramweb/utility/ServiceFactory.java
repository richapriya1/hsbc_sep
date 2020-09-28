package com.instagramweb.utility;

import com.instagramweb.service.InstagramService;
import com.instagramweb.service.InstagramServiceInterface;

public class ServiceFactory {

	public static InstagramServiceInterface createObject(String string) {
		
		return new InstagramService();
	}

}
