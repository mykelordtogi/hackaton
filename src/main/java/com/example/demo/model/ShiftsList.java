package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShiftsList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String shiftScheds;
	
	public ShiftsList(){
		
	}
	
	public ShiftsList(Integer id) {
		
		this.id = id;
		
	}

	
	
	public ShiftsList(String shiftScheds) {
		this.shiftScheds = shiftScheds;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	


	public String getShiftScheds() {
		return shiftScheds;
	}

	public void setShiftScheds(String shiftScheds) {
		this.shiftScheds = shiftScheds;
	}

	@Override
	public String toString() {
		return shiftScheds;
	}
	
	
}
