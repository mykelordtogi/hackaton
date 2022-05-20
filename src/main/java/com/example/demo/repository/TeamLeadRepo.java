package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TeamLead;

public interface TeamLeadRepo extends JpaRepository<TeamLead, Integer> {

}
