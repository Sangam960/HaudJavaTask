package com.haud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haud.entity.Simcard;

@Repository
public interface SimcardRepository extends JpaRepository<Simcard, Integer>{

	public List<Simcard> findByCustomer_Id(int id);
	
	
}
