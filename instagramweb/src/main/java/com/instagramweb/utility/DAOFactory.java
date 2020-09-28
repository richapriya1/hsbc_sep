package com.instagramweb.utility;

import com.instagramweb.dao.InstagramDAO;
import com.instagramweb.dao.InstagramDAOInterface;

public class DAOFactory {

	public static InstagramDAOInterface createObject(String string) {
		
			return new InstagramDAO();
		
	}

}
