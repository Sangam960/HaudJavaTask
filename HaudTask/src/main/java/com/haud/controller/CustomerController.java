package com.haud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haud.entity.Customer;
import com.haud.entity.Simcard;
import com.haud.service.CustomerServiceImpl;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	private  JavaMailSender javaMailSender;
	
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@GetMapping("/getcustomersim/{name}")
	public ResponseEntity<List<Simcard>> getAllCustomerSim(@PathVariable String name)
	{
		List<Simcard>  simcard= customerService.getAllCustomerSim(name);

		HttpHeaders h=new  HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Simcard>>(simcard,h,HttpStatus.OK);
	}

	
    public  void sendMail()
    {
    	Date date=new Date();
    	List<Customer> customer=customerService.getCustomer(date);
    	
        for (Customer customer2 : customer) {
        	
        	SimpleMailMessage sm=new SimpleMailMessage();
        	sm.setFrom("Sangmeshwar");
        	sm.setTo(customer2.getEmail());
        	sm.setText("Happy Birthday Dear Customer"+customer2.getName());
        	sm.setSubject("Birthday Wish");
        	javaMailSender.send(sm);
		}
    	
    }
    
	
}
