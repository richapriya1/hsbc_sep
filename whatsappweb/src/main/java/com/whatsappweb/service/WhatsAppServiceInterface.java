package com.whatsappweb.service;

import java.util.List;

import com.whatsappweb.entity.WhatsAppUser;

public interface WhatsAppServiceInterface {

	int createProfileService(WhatsAppUser u);

	boolean loginProfile(WhatsAppUser fe);

	List<WhatsAppUser> friendProfile(WhatsAppUser fe);

}
