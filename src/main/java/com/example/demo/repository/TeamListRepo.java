package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DepartmentsList;
import com.example.demo.model.TeamsList;

public interface TeamListRepo extends JpaRepository<TeamsList, Integer> {

}
