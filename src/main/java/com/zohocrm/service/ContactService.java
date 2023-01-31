package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contact;

public interface ContactService {

	// we will build one method
   public void saveContact(Contact contact);  // give the entity class name ( Contact contact )

   
   // create a method which will return List of Contact
   		List <Contact>  getContacts();   // press c+1 import List java.util


		public Contact getContactById(long id);
	   
	   
   
}
