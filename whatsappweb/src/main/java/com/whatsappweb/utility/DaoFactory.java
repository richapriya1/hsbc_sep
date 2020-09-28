package com.whatsappweb.utility;

import com.whatsappweb.dao.WhatsAppDao;
import com.whatsappweb.dao.WhatsAppDaoInterface;

public class DaoFactory {
private DaoFactory() {
		
	}
	public static WhatsAppDaoInterface createObject(String m) {
		WhatsAppDaoInterface is=null;
		if(m.equals("admin")) {
			is=new WhatsAppDao();
		}
		return is;
	}
}
