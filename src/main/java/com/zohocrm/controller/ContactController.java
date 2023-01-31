package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {

	@Autowired     // creating Bean
	private ContactService contactService;

//-------------------------------------------------------------------------------------------------------------	
	// bulling module
	@Autowired
	private BillingService billingService;
	
//---------------------------------------------------------------------------------------------------------------	
	//lets build a method 
	@RequestMapping("/listcontacts")
	public String listContacts(Model model) {
		List<Contact> contacts = contactService.getContacts();   // we don't have this method so press control+1 and create a method
		// assign it to new local variable
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
//--------------------------------------------------------------------------------------------------------------------------------------

	// we will add one method 
		@RequestMapping("/createBill")
		public String createBill(@RequestParam("id") long id, Model model) {
		Contact contact = contactService.getContactById(id);  //press control+1 and create a method
		// contact that we are returning will be stored in this  ( contact ) 
		model.addAttribute("contact",contact);
		
		return "generate_bill"; // lets create this jsp page
	}

//-----------------------------------------------------------------------------------------------------------------------------------

		// Lets build one method 
				@RequestMapping("/saveBill")
				public String saveBill(Billing bill) {     // we will build one entity-class ( Billing bill )
					billingService.generateBill(bill);
					
					return "list_bill";  // return to billing table, create this page
				}
		
	}
	

