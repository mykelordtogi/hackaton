package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeLogin;
import com.example.demo.model.TeamLeadLogin;
import com.example.demo.repository.LoginRepoEmployee;
import com.example.demo.repository.LoginRepoTeamLead;

@Service
public class LoginServiceTeamLead {
@Autowired
private LoginRepoTeamLead repo;
  
  public TeamLeadLogin login(String email, String password) {
	  TeamLeadLogin user = repo.findByEmailAndPassword(email, password);
   return user;
  }
 
}