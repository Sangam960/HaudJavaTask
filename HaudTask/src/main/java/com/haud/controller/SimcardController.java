package com.haud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haud.entity.Simcard;
import com.haud.service.SimcardService;

@RestController
@RequestMapping("/simcard")
public class SimcardController {

	@Autowired
	SimcardService simcardService;

	@PostMapping("/savesimcard/{name}")
    public ResponseEntity<Simcard> addSimcard(@PathVariable("name") String name,@RequestBody Simcard simcard)
    {
    	
    	simcardService.addSimToCustomer(name,simcard);
    	
    	return new ResponseEntity<Simcard>(HttpStatus.OK);    	
    }

	@GetMapping("/getallsim")
	public ResponseEntity<List<Simcard>> getAllSim()
	{
	
		List<Simcard> simcard=simcardService.fetchAllSim();
		

		return new ResponseEntity<List<Simcard>>(simcard,HttpStatus.OK);
	}
	
	
}
