package com.whatsappweb.utility;

import com.whatsappweb.service.WhatsAppService;
import com.whatsappweb.service.WhatsAppServiceInterface;

public class ServiceFactory {

private ServiceFactory() {
		
	}
	
	
	public static WhatsAppServiceInterface createObject(String nn) {
		// TODO Auto-generated method stub
		WhatsAppServiceInterface is=null;
		if(nn.equals("admin")) {
			is=new WhatsAppService();
		}
		return is;
	}

}
