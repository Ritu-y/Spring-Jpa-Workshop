package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cybage.model.Employee;
import com.cybage.repository.EmployeeRepository;

@Service
public class EmployeeServ {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Page<Employee> getAllEmployee(Pageable page){
		return employeeRepository.findAll(page);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee createEmployee(Employee emp) {
		employeeRepository.save(emp);
		return emp;
	}
	
	public void deleteEmployee(long id) {
		employeeRepository.delete(employeeRepository.getById(id));
	}
	
	public Employee getEmpById(Long id) {
		Employee employee=employeeRepository.getById(id);
		return employee;
	}
	
	public void updateEmployee(Employee emp,Long id) {
		Employee employee=employeeRepository.getById(id);
		employee.setEid(emp.getEid());
		employee.setEname(emp.getEname());
		employee.setDesgn(emp.getDesgn());
		
	}
	
	public Employee findEmployeebyName(String name) {
		return employeeRepository.findByEname(name);
	}
	
	public Employee findEmployeeByNameIgnorecase(String name) {
		return employeeRepository.getEmployeeByEnameIgnoreCase(name);
	}
	
	public Employee getEmployeeByName(String name) {
		return employeeRepository.getEmployeeByEname(name);
	}
}
