package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminLogin;
import com.example.demo.model.EmployeeLogin;
import com.example.demo.repository.LoginRepoAdmin;
import com.example.demo.repository.LoginRepoEmployee;

@Service
public class LoginServiceEmployee {
@Autowired
private LoginRepoEmployee repo;
  
  public EmployeeLogin login(String email, String password) {
	  EmployeeLogin user = repo.findByEmailAndPassword(email, password);
   return user;
  }
 
}