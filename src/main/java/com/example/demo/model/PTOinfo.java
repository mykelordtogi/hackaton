package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PTOinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String ptoInfo;
	
	public PTOinfo(){
		
	}

	
	
	public PTOinfo(Integer id, String ptoInfo) {
		this.id = id;
		this.ptoInfo = ptoInfo;
	}






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPtoInfo() {
		return ptoInfo;
	}

	public void setPtoInfo(String ptoInfo) {
		this.ptoInfo = ptoInfo;
	}
	
	

	@Override
	public String toString() {
		return ptoInfo;
	}
	
	
}
