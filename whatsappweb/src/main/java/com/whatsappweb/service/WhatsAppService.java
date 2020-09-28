package com.whatsappweb.service;

import java.util.List;

import com.whatsappweb.dao.WhatsAppDaoInterface;
import com.whatsappweb.entity.WhatsAppUser;
import com.whatsappweb.utility.DaoFactory;

public class WhatsAppService implements WhatsAppServiceInterface {

private WhatsAppDaoInterface id;
	
	public WhatsAppService() {
		
		id=DaoFactory.createObject("admindao");
	}
	@Override
	public int createProfileService(WhatsAppUser u) {
		int i=id.createProfileDAO(u);
		return i;
	}

	@Override
	public boolean loginProfile(WhatsAppUser fe) {
		return id.loginProfile(fe);
	}

	@Override
	public List<WhatsAppUser> friendProfile(WhatsAppUser fe) {
		return id.friendlistdao(fe);
	}

}
