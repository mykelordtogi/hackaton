package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.HazardPayInfoEnum;
import com.example.demo.enums.HybridSchedInfoEnum;

@Table
@Entity
public class HazardPayInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.ORDINAL)
	private HazardPayInfoEnum area;

	
public HazardPayInfo(){
		
	}
	
	
	public HazardPayInfo(Integer id, HazardPayInfoEnum area) {
		this.id = id;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HazardPayInfoEnum getArea() {
		return area;
	}

	public void setArea(HazardPayInfoEnum area) {
		this.area = area;
	}

	
	
	
	
}
