package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DepartmentsList;
import com.example.demo.model.HybridSchedInfo;
import com.example.demo.model.ShiftsList;
import com.example.demo.model.WorkType;

public interface WorkTypeRepo extends JpaRepository<WorkType, Integer> {

}
