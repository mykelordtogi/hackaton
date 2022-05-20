package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Set;
@Entity
public class TeamLead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false)
	private String leadName;
	
	
	@OneToOne
	@JoinColumn(name = "teamsList_id",updatable = false)
	private TeamsList teamsList;
	
	@OneToOne
	@JoinColumn(name = "departmentsList_id")
	private DepartmentsList departmentsList;
	
	
	@OneToOne
	@JoinColumn(name = "employeeList_id")
	private Employee employeeList;
	
	public TeamLead()
	{
		
	}
	
	
	

	public TeamLead(Integer id, String leadName, TeamsList teamsList, DepartmentsList departmentsList,
			Employee employeeList) {
		
		this.id = id;
		this.leadName = leadName;
		this.teamsList = teamsList;
		this.departmentsList = departmentsList;
		this.employeeList = employeeList;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getLeadName() {
		return leadName;
	}




	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}




	public TeamsList getTeamsList() {
		return teamsList;
	}




	public void setTeamsList(TeamsList teamsList) {
		this.teamsList = teamsList;
	}




	public DepartmentsList getDepartmentsList() {
		return departmentsList;
	}




	public void setDepartmentsList(DepartmentsList departmentsList) {
		this.departmentsList = departmentsList;
	}




	public Employee getEmployeeList() {
		return employeeList;
	}




	public void setEmployeeList(Employee employeeList) {
		this.employeeList = employeeList;
	}

	


}
