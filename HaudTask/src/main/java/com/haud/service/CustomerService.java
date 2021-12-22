package com.haud.service;

import java.util.Date;
import java.util.List;

import com.haud.entity.Customer;
import com.haud.entity.Simcard;


public interface CustomerService {

	
	public String saveCustomer(Customer customer); 
	
	
	
	public List<Simcard> getAllCustomerSim(String name);
	
	public List<Customer> getCustomer(Date currentDate);
}
