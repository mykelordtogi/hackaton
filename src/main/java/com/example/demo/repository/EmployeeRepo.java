package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminLogin;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeLogin;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
