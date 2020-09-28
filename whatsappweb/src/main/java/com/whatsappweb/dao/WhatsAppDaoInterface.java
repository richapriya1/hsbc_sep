package com.whatsappweb.dao;

import java.util.List;

import com.whatsappweb.entity.WhatsAppUser;

public interface WhatsAppDaoInterface {

	int createProfileDAO(WhatsAppUser u);

	boolean loginProfile(WhatsAppUser fe);

	List<WhatsAppUser> friendlistdao(WhatsAppUser fe);

}
