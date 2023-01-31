package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Lead;

public interface LeadService {

		public void saveOneLead(Lead lead); // here it is suppose to be Dto but i m not using the dto
										 // Directly using the Entity Class

		public Lead getLeadById(long id); // supply id here
		
		// delete the lead
		public void deleteLeadById(long id);

		public List<Lead> getAllLeads();   // change the void to list of lead
}
