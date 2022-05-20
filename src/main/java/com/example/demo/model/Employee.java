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
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;
	
	@Column(length = 128, nullable = false)
	private String lastName;
	
	@Column(length = 128, nullable = false)
	private String firstName;
	
	@Column(length = 128, nullable = false)
	private String middleName;
	
	@Column(length = 128, nullable = false)
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	
	@Column(length = 128, nullable = false)
	private String gender;
	
	@Column(length = 128, nullable = false)
	private String address;
	
	@Column(length = 128, nullable = false)
	private String mobileNum;
	
	@Column(length = 128, nullable = false)
	private String designation;
	
	@Column(length = 128, nullable = false)
	private String status;
	
	@OneToOne
	//@Transient
	@JoinColumn(name = "teamLead_id", updatable = false)
	private TeamLead teamLead;
	
	@OneToOne
	@JoinColumn(name = "shifts_id")
	private ShiftsList shifts;
	
	@OneToOne
	@JoinColumn(name = "pto_id")
	private PTOinfo pto;
	
	@OneToOne
	@JoinColumn(name = "workType_id")
	private WorkType workType;
	
	@OneToOne
	@JoinColumn(name = "hazardPayInfo_id", updatable = false)
	private HazardPayInfo hazardPayInfo;
	
	@OneToOne
	@JoinColumn(name = "departments_id")
	private DepartmentsList departments;
	
	@OneToOne
	@JoinColumn(name = "teams_id")
	private TeamsList teamName;
	
	
	@OneToOne
	@JoinColumn(name = "hybridSched_id")
	private HybridSchedInfo hybridSchedInfo;
	
	@OneToOne
	@JoinColumn(name = "bonus_id")
	private AttendanceBonusInfo bonusInfo;
	
	public Employee()
	{
		
	}

	public Employee(Long employee_id, String lastName, String firstName, String middleName, String email,
			Date birthdate, String gender, String address, String mobileNum, String designation, 
			String status, TeamLead teamLead,ShiftsList shifts,PTOinfo pto,WorkType workType,HazardPayInfo hazardPayInfo, 
			DepartmentsList departments,TeamsList teamName,HybridSchedInfo hybridSchedInfo,AttendanceBonusInfo bonusInfo) {
		
		this.employee_id = employee_id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.email = email;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.mobileNum = mobileNum;
		this.designation = designation;
		this.status = status;
		this.teamLead = teamLead;
		this.shifts = shifts;
		this.pto = pto;
		this.workType = workType;
		this.hazardPayInfo = hazardPayInfo;
		this.departments = departments;
		this.teamName = teamName;
		this.hybridSchedInfo = hybridSchedInfo;
		this.bonusInfo = bonusInfo;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TeamLead getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(TeamLead teamLead) {
		this.teamLead = teamLead;
	}

	public ShiftsList getShifts() {
		return shifts;
	}

	public void setShifts(ShiftsList shifts) {
		this.shifts = shifts;
	}

	public PTOinfo getPto() {
		return pto;
	}

	public void setPto(PTOinfo pto) {
		this.pto = pto;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public HazardPayInfo getHazardPayInfo() {
		return hazardPayInfo;
	}

	public void setHazardPayInfo(HazardPayInfo hazardPayInfo) {
		this.hazardPayInfo = hazardPayInfo;
	}

	public DepartmentsList getDepartments() {
		return departments;
	}

	public void setDepartments(DepartmentsList departments) {
		this.departments = departments;
	}

	public TeamsList getTeamName() {
		return teamName;
	}

	public void setTeamName(TeamsList teamName) {
		this.teamName = teamName;
	}

	public HybridSchedInfo getHybridSchedInfo() {
		return hybridSchedInfo;
	}

	public void setHybridSchedInfo(HybridSchedInfo hybridSchedInfo) {
		this.hybridSchedInfo = hybridSchedInfo;
	}

	public AttendanceBonusInfo getBonusInfo() {
		return bonusInfo;
	}

	public void setBonusInfo(AttendanceBonusInfo bonusInfo) {
		this.bonusInfo = bonusInfo;
	}
	
	

	


}
