package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttendanceBonusInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private Integer bonusPerMonth;
	
	public AttendanceBonusInfo(){
		
	}
	
	


	public AttendanceBonusInfo(Integer id, Integer bonusPerMonth) {
		this.id = id;
		this.bonusPerMonth = bonusPerMonth;
	}


	


	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getBonusPerMonth() {
		return bonusPerMonth;
	}




	public void setBonusPerMonth(Integer bonusPerMonth) {
		this.bonusPerMonth = bonusPerMonth;
	}




//	@Override
//	public String toString() {
//		return bonusPerMonth;
//	}
//	
	
}
