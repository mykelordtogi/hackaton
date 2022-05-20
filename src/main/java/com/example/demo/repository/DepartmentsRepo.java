package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DepartmentsList;

public interface DepartmentsRepo extends JpaRepository<DepartmentsList, Integer> {

}
