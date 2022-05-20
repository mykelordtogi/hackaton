package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminLogin;



@Repository
public interface LoginRepoAdmin extends JpaRepository<AdminLogin, Long>{
	AdminLogin findByEmailAndPassword(String email, String password);

}