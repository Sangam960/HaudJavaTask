package com.haud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haud.entity.Customer;
import com.haud.entity.Simcard;
import com.haud.repository.CustomerRepository;
import com.haud.repository.SimcardRepository;

@Service
public class SimcardServiceImpl implements SimcardService {

	@Autowired
	SimcardRepository simcardRepository;

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void addSimToCustomer( String name,Simcard simcard) {
		
        Customer customer=customerRepository.findByName(name);

        simcard.setCustomer(customer);
        
        simcardRepository.save(simcard);
	}

	@Override
	public List<Simcard> fetchAllSim() {
		
		List<Simcard> simcard=simcardRepository.findAll();
		return simcard;
	}
	
	

}
