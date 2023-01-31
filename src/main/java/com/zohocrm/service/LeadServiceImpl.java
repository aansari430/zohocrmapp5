package com.zohocrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Lead;
import com.zohocrm.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	// now we can create the bean/object in two ways , 1st constructor based injection 
	// 2nd  Using @Autowired
// INTERVIEW QUE. how do u use constructor based injection
	
	@Autowired  //right now using @Autowired for creating been 
	private LeadRepository leadRepo;
	
	@Override
	public void saveOneLead(Lead lead) {
		//lets save it
		leadRepo.save(lead);

	}

	@Override
	public Lead getLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);           // deleting the record
		
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();  // press control+1 assign it to new local variable leads
		return leads;   // and return leads
	}

}
