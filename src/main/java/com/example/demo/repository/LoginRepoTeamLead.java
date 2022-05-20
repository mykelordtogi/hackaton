package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminLogin;
import com.example.demo.model.TeamLeadLogin;

@Repository
public interface LoginRepoTeamLead extends JpaRepository<TeamLeadLogin, Long>{
	TeamLeadLogin findByEmailAndPassword(String email, String password);

}
