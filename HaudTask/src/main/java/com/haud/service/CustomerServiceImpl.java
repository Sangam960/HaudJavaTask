package com.haud.service;

import java.util.Date;
import java.util.List;

import javax.persistence.ExcludeDefaultListeners;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haud.entity.Customer;
import com.haud.entity.Simcard;
import com.haud.repository.CustomerRepository;
import com.haud.repository.SimcardRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	SimcardRepository simcardRepository;

	@Override
	public String saveCustomer(Customer customer) {

       customerRepository.save(customer);
       
       return "Data saved successfully";
	}

	@Override
	public List<Simcard> getAllCustomerSim(String name) {
		
 
		Customer customer=customerRepository.findByName(name);
		System.out.println(customer);
		
		List<Simcard> simcard=simcardRepository.findByCustomer_Id(customer.getId());
	
		return simcard;
	}

	@Override
	public List<Customer> getCustomer(Date currentDate) {
		
		
		return customerRepository.findByDob(currentDate);
	}


	


	

}
