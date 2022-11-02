package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
