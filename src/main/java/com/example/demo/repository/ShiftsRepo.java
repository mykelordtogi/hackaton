package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DepartmentsList;
import com.example.demo.model.ShiftsList;

public interface ShiftsRepo extends JpaRepository<ShiftsList, Integer> {

}
