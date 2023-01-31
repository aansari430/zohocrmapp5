package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.ContactService;
import com.zohocrm.service.LeadService;


@Controller
public class LeadController {

	//IN-ORDER TO SAVE THE LEAD WE HAVE TO CREATE THE BEAN/OBJECT ODF SERVICE LAYER
	@Autowired
	private LeadService leadService;
	
	// To save the contact we need to create one Bean
	@Autowired
	private ContactService contactService;
	
	
	
	//LET'S BUILD A HANDLER METHOD
	
	// some people may write this way
	@RequestMapping(value="/createLead", method = RequestMethod.GET)
	//@RequestMapping("/createLead")
	public String viewCreateLeadForm() {
		return "create_lead";  // lets create this jsp page 
	}
	
	
	// some people may write this way
	@RequestMapping(value="/saveLead", method = RequestMethod.POST)
	//@RequestMapping(value="/saveLead")
	public  String saveLead(@ModelAttribute("lead") Lead lead, Model model){
		
		// now save this
	leadService.saveOneLead(lead);	
	model.addAttribute("lead", lead);
	return"lead_info";
  }
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
     
	
		// Now lets build one method convertLead
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model model) {   // based on id we need to get the lead from the DB
		Lead lead = leadService.getLeadById(id);  // now we got the lead data, when we click on convert button it will get id
												  //  based on the id i get the lead ,  now take that lead and move that to contacts table
		
   // In-order to move that in contact table:-
		Contact contact = new Contact();
		
  // Now we will copy the data from lead to contact
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
  // now to save the contact we need to create one Bean @Autowired	
		contactService.saveContact(contact);
		
  // calling that delete method 
		leadService.deleteLeadById(id);
		
		
  // Now we get all the contacts & go to the contact page
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
		
		return "list_contacts";     // return to list_contacts page after clicking convert button
	}  
	
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	@RequestMapping("/listleads")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();    // we don't have this method so control +1 and create a method
	// assign it to new local variable leads
		
		model.addAttribute("leads", leads);
		
		return "list_leads";  // go to create this page & lets build table	
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	// Create one method called leadInfo
		@RequestMapping("/leadInfo")
		public String leadInfo(@RequestParam("id")long id, Model model) {
			Lead lead = leadService.getLeadById(id);
			model.addAttribute("lead",lead);
		return "lead_info";   // return to this page
	 }
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------
		
	
}
