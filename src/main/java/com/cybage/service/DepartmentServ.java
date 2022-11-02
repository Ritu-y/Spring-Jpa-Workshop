package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Department;
import com.cybage.repository.DepartmentRepository;

@Service
public class DepartmentServ {

	@Autowired
	DepartmentRepository departmentRepository;
	
//	public List<Department> getDepartments(){
//		return departmentRepository.findAll();
//	}
	
	public Department createDepartment(Department dept) {
		departmentRepository.save(dept);
		return dept;
	}
	
//	public void deleteDepartment(long id) {
//		departmentRepository.delete(departmentRepository.getById(id));
//	}
//	
//	public Department getDeptById(Long id) {
//		Department department=departmentRepository.getById(id);
//		return department;
//	}
//	
//	public void updateDepartment(Department dept,Long id) {
//		Department department=departmentRepository.getById(id);
//		department.setDid(dept.getDid());
//		department.setName(dept.getName());
//		
//	}
}
