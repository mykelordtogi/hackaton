package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.HybridSchedInfoEnum;

@Table
@Entity
public class HybridSchedInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	@Enumerated(EnumType.STRING)
	private HybridSchedInfoEnum team;
	
	public HybridSchedInfo()
	{
		
	}

	public HybridSchedInfo(Integer id, HybridSchedInfoEnum team) {
		
		this.id = id;
		this.team = team;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HybridSchedInfoEnum getTeam() {
		return team;
	}

	public void setTeam(HybridSchedInfoEnum team) {
		this.team = team;
	}

	
	
}
