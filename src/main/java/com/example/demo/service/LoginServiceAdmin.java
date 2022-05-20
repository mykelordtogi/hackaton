package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminLogin;
import com.example.demo.repository.LoginRepoAdmin;


@Service
public class LoginServiceAdmin {
@Autowired
private LoginRepoAdmin repo;
  
  public AdminLogin login(String email, String password) {
	  AdminLogin user = repo.findByEmailAndPassword(email, password);
   return user;
  }
 
}