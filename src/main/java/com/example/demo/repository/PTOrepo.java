package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DepartmentsList;
import com.example.demo.model.HybridSchedInfo;
import com.example.demo.model.PTOinfo;
import com.example.demo.model.ShiftsList;

public interface PTOrepo extends JpaRepository<PTOinfo, Integer> {

}
