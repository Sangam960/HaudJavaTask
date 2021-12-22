package com.haud.service;

import java.util.List;

import com.haud.entity.Simcard;

public interface SimcardService {

	public void addSimToCustomer(String name,Simcard simcard);
	
    public List<Simcard> fetchAllSim();
	
}
