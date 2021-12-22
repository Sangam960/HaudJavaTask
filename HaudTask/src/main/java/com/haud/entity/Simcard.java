package com.haud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Sim")
@Builder
@Setter
@Getter
public class Simcard {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "simcard_id")
	private Integer id;


	private Integer sIMNumber;
	private Integer iMSINumber;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getsIMNumber() {
		return sIMNumber;
	}
	public void setsIMNumber(Integer sIMNumber) {
		this.sIMNumber = sIMNumber;
	}
	public Integer getiMSINumber() {
		return iMSINumber;
	}
	public void setiMSINumber(Integer iMSINumber) {
		this.iMSINumber = iMSINumber;
	}
	
}
